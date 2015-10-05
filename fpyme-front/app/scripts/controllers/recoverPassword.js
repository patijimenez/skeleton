'use strict';

angular.module('fpymeFrontApp')
  .controller('RecoverPasswordCtrl', function ($scope, $routeParams, registrationService, $location, urlService) {
        $scope.disableSubmit = false;
        $scope.changePassword = function () {
            $scope.disableSubmit = true;
            registrationService.changePassword($routeParams.tokenId, $scope.password).then(function (data) {
                if(data.changed) {
                    $scope.showCorrect = true;
                }
            }, function () {
                //Error occured
                $scope.showIncorrect = true;
                $scope.disableSubmit = false;
            });
        };
        $scope.closeCorrect = function () {
            $scope.showCorrect = false;
            location.href = urlService.getBasePath() + '/app/auth/login';
        };
        $scope.closeIncorrect = function () {
            $scope.showIncorrect = false;
        };
        registrationService.validatePasswordToken($routeParams.tokenId).then(function (data) {
            if(data.tokenFound) {
                $scope.validToken = true;
            } else {
                $scope.invalidToken = true;
            }
        }, function (data) {
            $scope.invalidToken = true;
        });
  });
