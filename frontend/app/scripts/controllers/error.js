(function () {
    'use strict';

    angular.module('fpymeFrontApp')
        .controller('ErrorCtrl', function ($scope, $routeParams, $http, $log, urlService) {
            $http.post(urlService.getBasePath() + '/api/v1/status/showError', {
                errorId: $routeParams.errorId
            }).success(function (data) {
                $log.log(data);
                $scope.error = data;
            });
        });
}());
