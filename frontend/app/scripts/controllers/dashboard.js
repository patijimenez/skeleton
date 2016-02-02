'use strict';

angular.module('fpymeFrontApp')
  .controller('DashboardCtrl', function ($scope, urlService) {
    $scope.baseUrl = urlService.getBasePath();
  });
