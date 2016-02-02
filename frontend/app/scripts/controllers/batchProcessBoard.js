'use strict';

angular.module('fpymeFrontApp')
  .controller('BatchProcessBoardCtrl', function ($scope, $log, $dialog, urlService, batchProcessService ) {
    $scope.baseUrl = urlService.getBasePath();
    $scope.spinner = null;
    $scope.message = null;
    $scope.errorMessage = null;

    $scope.searchCriteria = null;
    $scope.noOfPages = 0;
    $scope.currentPage = 1;
    $scope.maxSize = 25;
    $scope.saveProcessFlag = false;
    $scope.currentProcess = null;

    $scope.action = 'list';

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

    $scope.listBatchProcesses = function(){
      $scope.showSpinner("Buscando procesos ...");
      batchProcessService.listBatchProcesses($scope.maxSize, $scope.currentPage, $scope.searchCriteria).then(function(data){
        $scope.processesList = data.processesList;
        var numPages = Math.floor(data.total/$scope.maxSize);
        $scope.noOfPages = data.total % $scope.maxSize == 0 ? numPages : numPages + 1;

        $scope.spinnerStop();

      }, function(){
        $scope.errorMessage = "Error al obtener la lista de processos";
        $scope.spinnerStop();
      });
    };

    $scope.saveProcess = function(){
      $scope.showSpinner("Guardando información del proceso...");
      $scope.process.cronExpression = $scope.process.onDemand == 'true' ?  null : $scope.process.cronExpression;
      $scope.process.cronExpression = $scope.process.businessProcess == true ?  null : $scope.process.cronExpression;
      batchProcessService.saveProcess($scope.process).then(function(data){
        if(data.status){
          $scope.process = data.process;
          $scope.saveProcessFlag = true;
        }else{
          $scope.errorMessage = data.errorMessage;
        }
        $scope.spinnerStop();
      }, function(){
        $scope.errorMessage = "Error al guardar el proceso";
        $scope.spinnerStop();
      });
    };

    $scope.executeBatchProcess =  function(process){
      if(!process.active){
        $scope.errorMessage = "No se puede ejecutar. El proceso está inactivo";
        return;
      }
      $scope.confirmActionDialog(process.name, 'ejecutar', function(){
        $scope.showSpinner("Ejecutando el proceso: " + process.name + "...");
        $scope.currentProcess = null;
        batchProcessService.executeBatchProcess(process.id).then(function(data){
          $scope.spinnerStop();
          if(!data.status){
            $scope.errorMessage =  "Error al ejecutar el proceso";
          }else{
            $scope.message = "Procesando el evento " + data.processEventId;
            $scope.currentProcess = {
              name: process.name,
              id: process.id,
              eventId: data.processEventId
            };
          }
        }, function(){
          $scope.errorMessage = "Error al ejecutar el proceso";
          $scope.spinnerStop();
        });
      });

    };

    $scope.edit =  function(process){
      $scope.action = 'edit';
      _.delay(function(process){
         $scope.process = process;
         $scope.$digest();
      }, 100,process);

    };

    $scope.clean = function(){
      $scope.process = {
        name:"", description: "", onDemand: false, cronExpression: "", tasksScript: "",
        funcionalityScript: "", active: false, multipleTasks: true
      };
      if(scrollTo) {
        scrollTo(0, 0);
      }
    };
    $scope.cancel = function(){
      $scope.clean();
      $scope.action = 'list';
      if($scope.saveProcessFlag){
        $scope.saveProcessFlag = false;
        $scope.listBatchProcesses();
      }
    };

    $scope.$watch('currentPage', function(){
      $scope.listBatchProcesses();
    });

    $scope.$watch('process.businessProcess', function(){
      if($scope.process && $scope.process.businessProcess){
        $scope.process.onDemand = null;
        $scope.process.threadPoolSize = 1;
        $scope.process.active = true;
      }
    });

    $scope.$watch('process.multipleTasks', function(){
      if($scope.process){
        if($scope.process.multipleTasks==false){
          $scope.process.threadPoolSize = 1;
        }
         _.delay(function(){
             $scope.$digest();
         }, 100);
      }
    });

    $scope.editorOptions = {
      lineWrapping : true,
      lineNumbers: true,
      matchBrackets: true,
      mode: 'text/x-groovy'
    };

    $scope.funcScriptEditor = {
      lineWrapping : true,
      lineNumbers: true,
      matchBrackets: true,
      mode: 'text/x-groovy'
    };

    $scope.disableBatchProcess = function(process){
      $scope.confirmActionDialog(process.name, 'pausar', function(){
        $scope.showSpinner("Pausando el proceso...");
        batchProcessService.disableBatchProcess(process.id).then(function(data){
          $scope.spinnerStop();
          if(!data.status){
            $scope.errorMessage =  "Error al pausar el proceso";
          }else{
            $scope.listBatchProcesses();
          }
        }, function(){
          $scope.errorMessage = "Error al pausar el proceso";
          $scope.spinnerStop();
        });
      });
    };

    $scope.enableBatchProcess = function(process){
      $scope.confirmActionDialog(process.name, 'reiniciar', function(){
        $scope.showSpinner("Activando el proceso...");
        batchProcessService.enableBatchProcess(process.id).then(function(data){
          $scope.spinnerStop();
          if(!data.status){
            $scope.errorMessage =  "Error al activar el proceso";
          }else{
            $scope.listBatchProcesses();
          }
        }, function(){
          $scope.errorMessage = "Error al activar el proceso";
          $scope.spinnerStop();
        });
      });
    };

    $scope.confirmActionDialog = function(processName, actionLabel, callBackFunc){

      var opts = {
        backdrop: true,
        keyboard: true,
        backdropClick: true,
        templateUrl: 'views/batchProcessDialog.html',
        controller: ['$scope','dialog', 'data', function($scope, dialog, data) {
                      $scope.processName = data.processName;
                      $scope.actionLabel = data.actionLabel;
                      $scope.closeDialog = function(){
                        dialog.close();
                      };
                      $scope.ok = function(){
                        var result = { status: true };
                        dialog.close(result);
                      };
                    }],
        resolve:{
          'data': function(){
            var data = { actionLabel: actionLabel, processName: processName };
            return data;
          }
        }
      };
      var d = $dialog.dialog(opts);
      d.open().then(function (result) {
        if(result && result.status) {
          if(callBackFunc) callBackFunc();
        }
      });
    };


  });
