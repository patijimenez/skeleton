'use strict';

angular.module('fpymeFrontApp')
  .controller('ScriptingCtrl', function ($scope, $log, developerService) {

    $scope.editorOptions = {
      lineWrapping : false,
      lineNumbers: true,
      autofocus: true,
      matchBrackets: true,
      mode: 'text/x-groovy',
      theme: 'solarized dark', 
      indentUnit: 2,
      smartIdent: false,
    };

    $scope.spinners = {};

    $scope.showOutputSection = false;
    $scope.processing = false;

    $scope.showSpinner = function (spinnerName, opts, message, label){
      if(!opts) {
        opts = {
          lines: 13, // The number of lines to draw
          length: 4, // The length of each line
          width: 2, // The line thickness
          radius: 5, // The radius of the inner circle
          corners: 1, // cornersr roundness (0..1)
          rotate: 0, // The rotation offset
          direction: 1, // 1: clockwise, -1: counterclockwise
          color: '#000', // #rgb or #rrggbb
          speed: 1, // Rounds per second
          trail: 60, // Afterglow percentage
          shadow: false, // Whether to render a shadow
          hwaccel: false, // Whether to use hardware acceleration
          className: 'spinner', // The CSS class to assign to the spinner
          zIndex: 2e9, // The z-index (defaults to 2000000000)
          top: '-20', // Top position relative to parent in px
          left: 1100 // Left position relative to parent in px
        };
      }

      var target = document.getElementById(spinnerName);
      $scope.spinners[spinnerName] = new Spinner(opts).spin(target);
      if(message){
        $scope.loadingMessage = label;
        $scope[message] = true;
      }
    };

    $scope.stopSpinner = function(spinnerName, message){
      $scope.spinners[spinnerName].stop();
      $scope[message] = false;
      $scope.loadingMessage = null;
    };

    $scope.saveScript = function(){
      $scope.processing = true;
      $scope.showSpinner("loadInfo-spinner", null, "showLoadingMessage", "Guardando script");
      developerService.saveTempScript($scope.script, $scope.tempScript.key).then(function(data){
        $scope.stopSpinner("loadInfo-spinner", "showLoadingMessage");
        $scope.processing = false;
        if(data.status != true){
          $scope.errorMessage = "Error al guardar el script ...";
        } else {
          $scope.tempScript = data.tempScript;
          $scope.script = data.tempScript.text;
          $scope.errorMessage = null;
        }
      }, function (){
        $scope.stopSpinner("loadInfo-spinner", "showLoadingMessage");
        $scope.processing = false;
        $scope.errorMessage = "Error al guardar el script ...";
      });
    };

    $scope.executeScript = function (script) {
      $scope.processing = true;
      $scope.showSpinner("loadInfo-spinner", null, "showLoadingMessage", "Ejecutando");

      developerService.executeScript(script).then(function (data) {
        $scope.showOutputSection = true,
        $scope.result = data;
        $scope.processing = false;
        $scope.stopSpinner("loadInfo-spinner", "showLoadingMessage");
      }, function (){
        $scope.stopSpinner("loadInfo-spinner", "showLoadingMessage");
        $scope.processing = false;
      });
    };
  });
