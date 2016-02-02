'use strict';

angular.module('fpymeFrontApp')
    .factory('registrationService', function ($http, $q, urlService) {

        var register = function (data, personType) {
            var deferred = $q.defer();
            data.personTypeEntity = personType;
            $http.post(urlService.getBasePath() + "/api/v1/auth/register", data).success(function (data) {
                deferred.resolve(data);
            }).error(function (data) {
                    deferred.reject(data);
                });
            return deferred.promise;
        };

        return {
            rfcExists: function(rfc, accId) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + "/api/v1/auth/rfcExists", {
                    rfc: rfc, 
                    accId : accId
                }).success(function (data) {
                        deferred.resolve(data);
                    }).error(function (data) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            usernameExists: function(username) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + "/api/v1/auth/usernameExists", {
                    username: username
                }).success(function (data) {
                        deferred.resolve(data);
                    }).error(function (data) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            recoverPassword: function(username) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + '/api/v1/auth/recoverPassword', {
                    email: username
                }).success(function (data) {
                    deferred.resolve(data);
                }).error(function (data) {
                    deferred.reject(data);
                });
                return deferred.promise;
            },
            validatePasswordToken: function (token) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + '/api/v1/auth/validatePasswordToken', {
                    token: token
                }).success(function (data) {
                        deferred.resolve(data);
                    }).error(function (data) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            validateActivationToken: function (token) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + '/api/v1/auth/validateActivationToken', {
                    token: token
                }).success(function (data) {
                        deferred.resolve(data);
                    }).error(function (data) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            changePassword: function (token, password) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + '/api/v1/auth/changePassword', {
                    token: token,
                    password: password
                }).success(function (data) {
                        deferred.resolve(data);
                    }).error(function (data) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            },
            registerOther: function (other, personType) {
                other.type = "other";
                return register(other, personType);
            },
            registerIndividual: function (individual, personType) {
                individual.type = "individual";
                return register(individual, personType);
            },
            registerStudent: function (student, personType) {
                student.type = "student";
                return register(student, personType);
            },
            registerCompany: function (company, personType) {
                company.type = "company";
                return register(company, personType);
            },
            registerGovernment: function (government, personType) {
                government.type = "government";
                return register(government, personType);
            },
            validateRifRFC: function (rfc) {
                var deferred = $q.defer();
                $http.post(urlService.getBasePath() + '/api/v1/auth/validateRifRFC', {
                    rfc: rfc
                }).success(function (data) {
                        deferred.resolve(data);
                    }).error(function (data) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }
        };
    });
