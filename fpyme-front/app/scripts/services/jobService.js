'use strict';

angular.module('fpymeFrontApp')
  .factory('jobService', function ($http, $q, urlService)  {
    return {
      saveReportJob: function (report) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/triggerReportJob", {
          report: report
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No pudimos programar el reporte',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      getJobsList: function (maxSize, currentPage, searchCriteria) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/getJobsList", {
          maxSize : maxSize,
          currentPage : currentPage,
          searchCriteria: searchCriteria
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo obtener los reportes programados',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      deleteJob: function (report) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/deleteJob", {
          report: report
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo borrar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      pauseJob: function (report) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/pauseJob", {
          report: report
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo pausar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      resumeJob: function (report) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/resumeJob", {
          report: report
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo reiniciar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      saveNotificationJob: function (notification) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/triggerNotificationJob", {
          notification: notification
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No pudimos programar la notificacion',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      getNotificationsList: function () {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/getNotificationsList", {
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo obtener los reportes programados',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      deleteNotification: function (notification) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/deleteNotificationJob", {
          notification: notification
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo borrar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      pauseNotification: function (notification) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/pauseNotificationJob", {
          notification: notification
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo pausar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      resumeNotification: function (notification) {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/resumeNotificationJob", {
          notification: notification
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo reiniciar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      getScriptsAndTemplates: function () {
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/getScriptsAndTemplatesForNotifications", {
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo reiniciar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      },
      sendReportNow: function(report){
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + "/api/v1/job/sendReportNow", {
          report : report
        }).success(function (data) {
          defer.resolve(data);
        }).error(function (data) {
          var errorData = {
            description: 'No se pudo reiniciar el job',
            data: data
          };
          defer.reject(errorData);
        });

        return defer.promise;
      }
    }
  });
