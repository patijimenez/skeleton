'use strict';

angular.module('fpymeFrontApp')
  .factory('messageService', function ($http, $q, urlService) {
    // Public API here
    return {
      listCurrentMessages: function(){
        var defer = $q.defer();

        $http.get(urlService.getBasePath() + "/api/v1/message/listCurrentMessages").success(function (data) {
                defer.resolve(data);
            }).error(function (data) {
                var errorData = {
                    description: '',
                    data: data
                };
                defer.reject(errorData);
            });

        return defer.promise;
      },
      listCallMessages: function(){
        var defer = $q.defer();

        $http.get(urlService.getBasePath() + "/api/v1/message/listCallMessages").success(function (data) {
                defer.resolve(data);
            }).error(function (data) {
                var errorData = {
                    description: '',
                    data: data
                };
                defer.reject(errorData);
            });

        return defer.promise;
      },
      listLastMessages: function(maxElements){
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/message/listLastMessages", {
          maxElements: maxElements
        }).success(function (data) {
                defer.resolve(data);
            }).error(function (data) {
                var errorData = {
                    description: '',
                    data: data
                };
                defer.reject(errorData);
            });

        return defer.promise;
      }
    };
  });
