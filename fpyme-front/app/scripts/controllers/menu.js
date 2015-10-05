(function () {
  'use strict';

  angular.module('fpymeFrontApp')
    .controller('MenuCtrl', function ($scope, $location, urlService, loggedService) {
      $scope.baseUrl = urlService.getBasePath();

      loggedService.hasPermission('auth:su').then(function (data) {
        if (data.allowed) {
          $scope.suPermission = data.allowed;
        } else {
          loggedService.isRunAs().then(function (data) {
            $scope.suPermission = data.outcome;
          });
        }
      });
    });
}());

