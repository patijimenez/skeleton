'use strict';

angular.module('fpymeFrontApp')
  .controller('RunScriptsCtrl', function ($scope, developerService, urlService) {

    $scope.processing = false;
    $scope.baseUrl = urlService.getBasePath();

    $scope.getScripts = function(){
      developerService.getAdminScritps().then(function (data){
         $scope.scripts = data;
      });
    }
        
    $scope.executeStoredScript = function (script) {
      var opts = {
                lines: 15, // The number of lines to draw
                length: 15, // The length of each line
                width: 4, // The line thickness
                radius: 15, // The radius of the inner circle
                corners: 1, // Corner roundness (0..1)
                rotate: 0, // The rotation offset
                direction: 1, // 1: clockwise, -1: counterclockwise
                color: '#000', // #rgb or #rrggbb
                speed: 1, // Rounds per second
                trail: 60, // Afterglow percentage
                shadow: false, // Whether to render a shadow
                hwaccel: false, // Whether to use hardware acceleration
                className: 'spinner', // The CSS class to assign to the spinner
                zIndex: 2e9, // The z-index (defaults to 2000000000)
                top: '-2', // Top position relative to parent in px
                left: 'auto' // Left position relative to parent in px
              };
      var target = document.getElementById('save-spinner');
      var spinner = new Spinner(opts).spin(target);
      $scope.processing = true;
      developerService.executeStoredScript(script).then(function (data) {
        $scope.result = data;
        spinner.stop();
        $scope.processing = false;
      }, function (){
        spinner.stop();
        $scope.processing = false;
      });
    };
    $scope.getScripts();

    $scope.save = function(){
       jQuery('#scriptForm').submit();
    };

  });
