'use strict';

angular.module('fpymeFrontApp')
  .factory('userService', function ($http, $q, urlService) {
    return {
      getSessionsData: function() {
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/users/getSessionsData',{

        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      },
      endSession: function (key) {
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/users/endSession',{
          key: key
        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      },
      getSessions: function () {
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/users/getSessions',{

        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      },
      getUserType : function(){
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/users/getUserType',{

        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      },
      validateTemporalUser : function(rfc, email){
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/tempUser/validateRfcAndEmail',{
          rfc: rfc,
          email: email
        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      },
      registerTempUser : function(user){
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/tempUser/createTemporalUser',{
          userData : user
        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      },
      getTempUserById: function(userId){
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/tempUser/getTemporalUserById',{
          userId : userId
        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      }, 
      isProvider: function(){
        var defer = $q.defer();
        $http.post(urlService.getBasePath() + '/api/v1/tempUser/isProvider',{
        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        return defer.promise;
      }, 
      getDispatchInformationByUser: function(){
        var defer = $q.defer();

        $http.post(urlService.getBasePath() + '/api/v1/users/getDispatchInformationByUser',{
        }).success(function (data){
          defer.resolve(data);
        }).error(function (data){
          defer.reject(data);
        });
        
        return defer.promise;
      }
    };
  });
