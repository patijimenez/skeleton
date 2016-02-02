'use strict';

angular.module('fpymeFrontApp')
  .controller('SessionsCtrl', function ($scope, userService) {
    var listSessions = function () {
      userService.getSessionsData().then(function (data) {
        $scope.sessionData = data;
      });
      userService.getSessions().then(function (data) {
        $scope.sessions = data;
      });
    };

    $scope.endSession = function (key) {
      userService.endSession(key).then(function () {
        listSessions();
      });
    };

    listSessions();

  });
