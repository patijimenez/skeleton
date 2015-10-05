'use strict';

angular.module('fpymeFrontApp')
  .controller('BatchProcessEventConsoleCtrl', function ($scope, $log, $routeParams, urlService, batchProcessService) {
    $scope.baseUrl = urlService.getBasePath();
    $scope.spinner = null;
    $scope.message = null;
    $scope.errorMessage = null;

    $scope.getConsoleBatchProcessEvent = function(){
      batchProcessService.getConsoleBatchProcessEvent($routeParams.processEventId).then(function(data){
        $scope.data = data;
        //$("html, body").animate({ scrollTop:  $("#spnbottom").offset().top }, 'slow' );
        if(data.processEvent.status == 'PROCESSING'){
          _.delay($scope.getConsoleBatchProcessEvent, 500);
        }
      }, function(){
        $scope.errorMessage = "Error al obtener el log de consola";
      });
    };

    $scope.getConsoleBatchProcessEvent();
  });
