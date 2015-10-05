'use strict';

angular.module('fpymeFrontApp')
        .factory('loggedService', function($http, $q, urlService) {

    // Public API here
    return {
        su: function (username) {
            var deferred = $q.defer();
            $http.post(urlService.getBasePath() + '/api/v1/auth/su', {
                username: username
            }, {
                cache: false
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status, headers, config) {
                var description;

                if (status == 401) {
                    description = "El usuario no tiene sesión en la aplicación";
                } else {
                    description = "Ha ocurrido un error inesperado";
                }

                var errorData = {
                    status: status,
                    data: data,
                    description: description
                };
                deferred.reject(errorData);
            });
            return deferred.promise;
        },
        release: function () {
            var deferred = $q.defer();
            $http.post(urlService.getBasePath() + '/api/v1/auth/releaseRunAs', {
            }, {
                cache: false
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status, headers, config) {
                var description;

                if (status == 401) {
                    description = "El usuario no tiene sesión en la aplicación";
                } else {
                    description = "Ha ocurrido un error inesperado";
                }

                var errorData = {
                    status: status,
                    data: data,
                    description: description
                };
                deferred.reject(errorData);
            });
            return deferred.promise;
        },
        isRunAs: function (username) {
            var deferred = $q.defer();
            $http.post(urlService.getBasePath() + '/api/v1/auth/isRunAs', {
            }, {
                cache: false
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status, headers, config) {
                var description;

                if (status == 401) {
                    description = "El usuario no tiene sesión en la aplicación";
                } else {
                    description = "Ha ocurrido un error inesperado";
                }

                var errorData = {
                    status: status,
                    data: data,
                    description: description
                };
                deferred.reject(errorData);
            });
            return deferred.promise;
        },
        hasPermission: function(permission) {
            var deferred = $q.defer();
            $http.post(urlService.getBasePath() + '/api/v1/auth/hasPermission', {
                permission: permission
            }, {
                cache: true
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status, headers, config) {
                var description;

                if (status == 401) {
                    description = "El usuario no tiene sesión en la aplicación";
                } else {
                    description = "Ha ocurrido un error inesperado";
                }

                var errorData = {
                    status: status,
                    data: data,
                    description: description
                };
                deferred.reject(errorData);
            });
            return deferred.promise;
        },
        getSubject: function() {
            var deferred = $q.defer();
            $http.get(urlService.getBasePath() + '/api/v1/auth/loggedIn').success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status, headers, config) {
                var description;

                if (status == 401) {
                    description = "El usuario no tiene sesión en la aplicación";
                } else {
                    description = "Ha ocurrido un error inesperado";
                }

                var errorData = {
                    status: status,
                    data: data,
                    description: description
                };
                deferred.reject(errorData);
            });
            return deferred.promise;
        },
        hasRole: function(role) {
            var deferred = $q.defer();
            $http.post(urlService.getBasePath() + '/api/v1/auth/hasRole', {
                role: role
            }, {
                cache: true
            }).success(function(data) {
                deferred.resolve(data);
            }).error(function(data, status, headers, config) {
                var description;

                if (status == 401) {
                    description = "El usuario no tiene sesión en la aplicación";
                } else {
                    description = "Ha ocurrido un error inesperado";
                }

                var errorData = {
                    status: status,
                    data: data,
                    description: description
                };
                deferred.reject(errorData);
            });
            return deferred.promise;
        }
    };
});
