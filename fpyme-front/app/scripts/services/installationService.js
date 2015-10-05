(function () {
    'use strict';
    angular.module('fpymeFrontApp')
        .factory('installationService', function ($http, $q, urlService) {
            return {
                createInstallationSession: function(fileName){
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/installationSession/registerSession", {
                        fileName: fileName
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No se ha podido registrar la sesion de instalacion',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                },

                getStateCouncelors: function(){
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/installationSession/getStateCouncelors", {
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No ha sido posible obtener los consejeros estatales',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                },

                getStateCouncelorTypes: function(){
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/installationSession/getStateCouncelorTypes", {
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No ha sido posible consultar el tipo de consejero',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                },

                getInstallationDoc: function(){
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/installationSession/getInstallationDoc", {
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No ha sido posible consultar el documento',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                },

                installationSessionAvailable: function(){
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/installationSession/installationSessionAvailable", {
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No ha sido posible consultar el documento',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                }
            };
        });
}());
