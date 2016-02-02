'use strict';
angular.module('fpymeFrontApp')
        .controller('AdministrarNotificacionesCtrl', function($scope, $log, jobService) {
    var setError = null;
    var setInfo = null;
    $scope.notificationData = {};
    jobService.getScriptsAndTemplates().then(function(data){
       $scope.scripts = data.scripts;
       $scope.mailTemplates = data.mailTemplates;
    });

    $scope.NotificationsList = function(){
      jobService.getNotificationsList().then(function(data){
           $scope.notifications = data;
        });
    };

    $scope.NotificationsList();

    $scope.saveNotification = function(){
      if($scope.notificationData.name && $scope.notificationData.name.length > 0){
        jobService.saveNotificationJob($scope.notificationData).then(function (data) {
          if(data.status){
            $scope.NotificationsList();
            $scope.clean();
            setInfo("La notificacion ha sido guardada");
          }
          else{
            setError(data.message);
          }
        }, function (){

        });
      }
    };

    $scope.deleteNotification = function(notification){
      jobService.deleteNotification(notification).then(function (data) {
        if(data.status){
          $scope.NotificationsList();
          setInfo("El reporte ha sido eliminado");
        }
        else{
          setError(data.message);
        }
      }, function (){
           setError("Error al eleiminar el reporte");
      });
    };

    $scope.pauseNotification = function(notification){
      jobService.pauseNotification(notification).then(function (data) {
        if(data.status){
          $scope.NotificationsList();
          setInfo("La notifiacion ha sido pausada");
        }
        else{
          setError(data.message);
        }
      }, function (){

      });
    };
    $scope.resumeNotification = function(notification){
      jobService.resumeNotification(notification).then(function (data) {
        if(data.status){
          $scope.NotificationsList();
          setInfo("La notificacion se fue reiniciada");
        }
        else{
          setError(data.message);
        }
      }, function (){

      });
    };

    $scope.viewNotification = function(notification){
        $scope.notificationData.id = notification.id
        $scope.notificationData.name = notification.name;
        $scope.notificationData.description = notification.description;
        $scope.notificationData.cronExpression = notification.cronExpression;
        $scope.notificationData.script = notification.script.id;
        $scope.notificationData.mailTemplate = notification.mailTemplate.id;
    };

    $scope.clean = function(){
      $scope.notificationData = {};
    };

    setError = function(error){
            $scope.showError = true;
            $scope.resultMessage = error;
            _.delay(function(){
                $scope.showError = false;
                $scope.$digest();
            }, 3000,'');
            $(window).scrollTop(0);
        };

        setInfo = function(text){
            $scope.showInfo = true;
            $scope.resultMessage = text;
            _.delay(function(){
                $scope.showInfo = false;
                $scope.$digest();
            }, 3000,'');
            $(window).scrollTop(0);
        };
});
