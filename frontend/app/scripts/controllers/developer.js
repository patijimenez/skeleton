'use strict';

angular.module('fpymeFrontApp')
  .controller('DeveloperCtrl', function ($scope, developerService) {
    $scope.createApplications = function () {
      developerService.createApplications().then(function () {
      });
    };
  });
