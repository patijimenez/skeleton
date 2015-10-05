'use strict';

angular.module('fpymeFrontApp')
  .controller('BatchProcessLogCtrl', function ($scope, $log, $routeParams, urlService, batchProcessService) {
    $scope.baseUrl = urlService.getBasePath();
    $scope.spinner = null;
    $scope.message = null;
    $scope.errorMessage = null;

    $scope.searchCriteria = null;
    $scope.max = 500;
    $scope.currentPage = 1;
    $scope.noOfPages = 0;
    $scope.offset = 0;
    $scope.taskStatusList = [ 'OK', 'ERROR', 'APPLICATION_ERROR', 'QUEUED' ]

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

    $scope.listBatchProcessTasksLog = function(){
      $scope.showSpinner("Buscando log de tareas ...");
      $scope.tasksLogList = [];
      batchProcessService.listBatchProcessTasksLog($routeParams.processEventId, $scope.max, $scope.currentPage, $scope.searchCriteria).then(function(data){
        $scope.tasksLogList = data.tasksLogList;
        $scope.event = data.event;
        $scope.process = data.process;
        $scope.total = data.total;

        var numPages = Math.floor(data.total/$scope.max);
        $scope.noOfPages = data.total % $scope.max == 0 ? numPages : numPages + 1;
        $scope.offset = ($scope.currentPage-1) * $scope.max;
        $scope.spinnerStop();
      }, function(){
        $scope.errorMessage = "Error al obtener la lista del log de tareas.";
        $scope.spinnerStop();
      });
    };

    $scope.$watch('currentPage', function(){
      $scope.listBatchProcessTasksLog();
    });

    $scope.executeSingleTask = function(taskLog){
      $scope.showSpinner("Ejecutando la tarea ...");
      batchProcessService.executeSingleTask(taskLog.id).then(function(data){
      if(!data.status){
        $scope.errorMessage = "Error al ejecutar la tarea.";
      }
      $scope.spinnerStop();
      }, function(){
        $scope.errorMessage = "Error al ejecutar la tarea.";
        $scope.spinnerStop();
      });
    };

  });