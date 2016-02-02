(function () {
    'use strict';

    angular.module('fpymeFrontApp')
        .controller('ErrorsCtrl', function ($scope, $http, urlService) {
            $http.get(urlService.getBasePath() + "/api/v1/status/listErrorTypes").success(function (data) {
                $scope.errors = data;
            });
        });
}());
