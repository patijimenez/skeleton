'use strict';

angular.module('fpymeFrontApp')
  .controller('BatchProcessEventsCtrl', function ($scope, $log, $routeParams, urlService, batchProcessService) {
    $scope.baseUrl = urlService.getBasePath();
    $scope.spinner = null;
    $scope.message = null;
    $scope.errorMessage = null;

    $scope.searchCriteria = null;
    $scope.max = 15;
    $scope.currentPage = 1;
    $scope.noOfPages = 0;

    $scope.showSpinner = function (message){
      $scope.message = null;
      $scope.errorMessage = null;
      var opts = {
          lines: 13, // The number of lines to draw
          length: 10, // The length of each line
          width: 3, // The line thickness
          radius: 8, // The radius of the inner circle
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
          top: '-35', // Top position relative to parent in px
          left: 500 // Left position relative to parent in px
      };
      var target = document.getElementById('save-spinner');
      $scope.spinner = new Spinner(opts).spin(target);
      if(scrollTo) {
        scrollTo(0, 0);
      }
      if(message){
        $scope.message = message;
      }
    };
    $scope.spinnerStop = function(){
       $scope.spinner.stop();
       $scope.message = null;
    };

    $scope.listBatchProcessEvents = function(){
      $scope.showSpinner("Buscando eventos ...");
      batchProcessService.listBatchProcessEvents($routeParams.processId, $scope.max, $scope.currentPage, $scope.searchCriteria).then(function(data){
        $scope.eventsList = data.eventsList;
        $scope.process = data.process;
        $scope.total = data.total;

        var numPages = Math.floor(data.total/$scope.max);
        $scope.noOfPages = data.total % $scope.max == 0 ? numPages : numPages + 1;
        $scope.spinnerStop();
      }, function(){
        $scope.errorMessage = "Error al obtener la lista de eventos";
        $scope.spinnerStop();
      });
    };

    $scope.$watch('currentPage', function(){
      $scope.listBatchProcessEvents();
    });


  });
