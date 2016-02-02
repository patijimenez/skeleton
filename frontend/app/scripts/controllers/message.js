'use strict';

angular.module('fpymeFrontApp')
  .controller('MessageCtrl', function ($scope, messageService) {
    messageService.listCurrentMessages().then(function (data) {
      $scope.messages = data;
    });
  });
