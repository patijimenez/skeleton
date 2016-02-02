'use strict';

angular.module('fpymeFrontApp')
.factory('batchProcessService', function ($http, $q, urlService) {
  return {
    listBatchProcesses: function (max, currentPage, searchCriteria) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/listBatchProcesses", {
          max: max,
          currentPage: currentPage,
          searchCriteria: searchCriteria
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    getBatchProcess: function (processId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/getBatchProcess", {
          processId: processId
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    saveProcess: function (processData) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/saveBatchProcess", {
          processData: processData
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    executeBatchProcess: function (processId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/executeBatchProcess", {
          processId: processId
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    listBatchProcessEvents: function (processId, max, currentPage, searchCriteria) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/listBatchProcessEvents", {
          processId: processId,
          max: max,
          currentPage: currentPage,
          searchCriteria: searchCriteria
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    listBatchProcessTasksLog: function (processEventId, max, currentPage, searchCriteria) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/listBatchProcessTasksLog", {
          processEventId: processEventId,
          max: max,
          currentPage: currentPage,
          searchCriteria: searchCriteria
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    getConsoleBatchProcessEvent: function (processEventId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/getConsoleBatchProcessEvent", {
          processEventId: processEventId
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    disableBatchProcess: function (batchProcessId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/disableBatchProcess", {
          batchProcessId: batchProcessId
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    enableBatchProcess: function (batchProcessId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/enableBatchProcess", {
          batchProcessId: batchProcessId
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    },
    executeSingleTask: function (taskLogId) {
      var defer = $q.defer();

      $http.post(urlService.getBasePath() +  "/api/v1/batchProcess/executeSingleTask", {
          taskLogId: taskLogId
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          defer.reject(data);
        });

        return defer.promise;
    }
  };
});
