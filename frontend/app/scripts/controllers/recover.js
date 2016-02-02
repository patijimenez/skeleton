'use strict';

angular.module('fpymeFrontApp')
  .controller('RecoverCtrl', function ($scope, registrationService, $dialog) {
        var t, dialog;

        t = '<div class="modal-header">'+
            '<h1>Notificación enviada</h1>'+
            '</div>'+
            '<div class="modal-body">'+
            '<p>Se ha enviado un correo electrónico al usuario con las instrucciones para generar una nueva contraseña.</p>'+
            '</div>'+
            '<div class="modal-footer">'+
            '<button ng-click="close()" class="btn btn-primary" >Cerrar</button>'+
            '</div>';

        dialog = $dialog.dialog({
            backdrop: true,
            keyboard: true,
            backdropClick: true,
            template:  t, // OR: templateUrl: 'path/to/view.html',
            controller: 'GenericDialogCtrl'
        });

        $scope.open = function () {
            $scope.shouldBeOpen = true;
        };

        $scope.close = function () {
            $scope.shouldBeOpen = false;
        };

        $scope.opts = {
            backdropFade: true,
            dialogFade:true
        };


        $scope.disableSubmit = false;
        $scope.recoverPassword = function () {
            $scope.disableSubmit = true;
            registrationService.recoverPassword($scope.email).then(function (data) {
                dialog.open().then(function () {
                    $scope.disableSubmit = false;
                });
            }, function (data) {
                $scope.open();
                $scope.disableSubmit = false;
            });
        };
  });
