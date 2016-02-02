'use strict';

angular.module('fpymeFrontApp')
  .controller('SuCtrl', function ($scope, $location, loggedService, urlService) {
    loggedService.isRunAs().then(function (data) {
      $scope.release = data.outcome;
    });
    $scope.releaseRunAs = function () {
      loggedService.release().then(function (data) {
        location.href = urlService.getBasePath();
      });
    };
    $scope.su = function (email) {
      loggedService.su(email).then(function (data) {
        location.href = urlService.getBasePath();
      });
    };
  });
