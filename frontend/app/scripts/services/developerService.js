'use strict';

angular.module('fpymeFrontApp')
.factory('developerService', function ($http, $q, urlService) {
  return {
    deleteDocument: function (documentId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/deleteDocument", {
        documentId: documentId
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos ejecutar el query',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },
    editDocument: function (document) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/editDocument", {
        document: document
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos ejecutar el query',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },
    executeQuery: function (query) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/executeQuery", {
        query: query
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos ejecutar el query',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },
    executeScript: function (script) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/executeScript", {
        script: script
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos ejecutar el script',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },
    saveTempScript: function(script, key){
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/saveTempScript", {
        script: script, 
        key: key
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos ejecutar el script',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },  
    executeStoredScript: function (script) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/executeStoredScript", {
        script: script
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos ejecutar el script',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },
    getAdminScritps: function (script) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/getAdminScritps", {
        script: script
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos obtener los scipts',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    },
    getRunScritps: function (maxSize, currentPage, searchCriteria) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() + "/api/v1/developer/getRunScritps", {
        maxSize : maxSize,
        currentPage : currentPage,
        searchCriteria : searchCriteria
      }).success(function (data) {
        defer.resolve(data);
      }).error(function (data) {
        var errorData = {
          description: 'No pudimos obtener los scipts',
          data: data
        };
        defer.reject(errorData);
      });

      return defer.promise;
    }
  };
});
