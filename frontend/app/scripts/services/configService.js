'use strict';

angular.module('fpymeFrontApp')
.factory('configService', function ($http, $q, urlService) {
  return {
    listConfigParams: function (params) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + '/api/v1/appConfig/getConfig', {
        params: params
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        defer.reject(data);
      });

      return defer.promise;
    }
  };
});
