'use strict';

angular.module('fpymeFrontApp')
  .controller('ECtrl', function ($scope, $routeParams) {
    $scope.errorId = $routeParams.errorId;
  });
