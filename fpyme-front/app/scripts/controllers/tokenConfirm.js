'use strict';

angular.module('fpymeFrontApp')
  .controller('TokenConfirmCtrl', function ($scope, $routeParams, registrationService) {
        $scope.validToken = false;
        $scope.invalidToken = false;
        registrationService.validateActivationToken($routeParams.tokenId).then(function (data) {
            if(data.tokenFound) {
                $scope.validToken = true;
                $scope.invalidToken = false;
            } else {
                $scope.invalidToken = true;
                $scope.validToken = false;
            }
        }, function (data) {
            $scope.invalidToken = true;
            $scope.validToken = false;
        });
  });
