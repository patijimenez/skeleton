'use strict';

angular.module('fpymeFrontApp')
  .controller('DbCtrl', function ($scope, developerService) {
    $scope.editorOptions = {
      lineWrapping : true,
      lineNumbers: true,
      autofocus: true,
      matchBrackets: true,
      mode: 'text/x-plsql'
    };
    $scope.executeQuery = function (query) {
      developerService.executeQuery(query).then(function (data) {
        $scope.queryData = data;
      });
    };
  });
