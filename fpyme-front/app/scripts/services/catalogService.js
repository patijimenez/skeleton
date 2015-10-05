(function () {
    'use strict';

    angular.module('fpymeFrontApp')
        .factory('catalogService', function ($http, $q, urlService) {
            return {
                listEconomicActivities: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listEconomicActivities").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las actividades económicas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listRejectionReasons: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listRejectionReasons").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los tipos de vialidad',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getRejectionReasonByType: function(rejectionReasonType){
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getRejectionReasonByType", {
                        rejectionReasonType: rejectionReasonType
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No fue posible obtener las razones de rechazo del tipo ' + rejectionReasonType,
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listRoadTypes: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listRoadTypes").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los tipos de vialidad',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listStratifications: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listStratifications").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las entidades federativas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listOtherTypes: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listOtherTypes").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las entidades federativas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listGovernmentTypes: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listGovernmentTypes").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las entidades federativas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listSettlementTypes: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listSettlementTypes").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los tipos de asentamiento',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listIndividualTypes: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listIndividualTypes").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las entidades federativas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listProponents: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listProponents").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los proponentes',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listNonStrategicSectors: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listNonStrategicSectors").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los sectores no estratégicos',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listSectors: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listSectors").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las entidades federativas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listStates: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listStates").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las entidades federativas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listMunicipalities: function (stateId) {
                    var defer = $q.defer();
                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listMunicipalities", {
                        stateId: stateId
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los municipios',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
								getMunicipalityById: function(municipalityId){
							  		var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getMunicipality", {
                        municipalityId: municipalityId
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los municipios',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
		
								},
                listPostalSettlements: function (postalCode) {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listPostalSettlements", {
                        postalCode: postalCode
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los asentamientos del código postal ' + postalCode,
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listCompanyProfileTypes: function () {
                    var defer = $q.defer();

                    $http.get(urlService.getBasePath() + "/api/v1/catalog/listCompanyProfileTypes").success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los tipos de sectores para empresas',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                showSettlementData: function (settlementId) {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/showSettlementData", {
                        settlementId: settlementId
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los datos del asentamiento ' + settlementId,
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listAllTemplateFields: function(){
                  var defer = $q.defer();

                  $http.post(urlService.getBasePath() + "/api/v1/catalog/listAllTemplateFields").success(function (data) {
                    defer.resolve(data);
                  }).error(function (data) {
                    var errorData = {
                      description: 'No ha sido posible listar los tipos de campos para las plantillas de convenios',
                      data: data
                    };
                    defer.reject(errorData);
                  });

                  return defer.promise;
                },
                listParticipants: function(){
                  var defer = $q.defer();

                  $http.post(urlService.getBasePath() + "/api/v1/catalog/listParticipants").success(function (data) {
                    defer.resolve(data);
                  }).error(function (data) {
                    var errorData = {
                      description: 'No ha sido posible listar los aportantes',
                      data: data
                    };
                    defer.reject(errorData);
                  });

                  return defer.promise;
                },
                listHungerMunicipalities: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listHungerMunicipalities", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los municipios',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listViolenceMunicipalities: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listViolenceMunicipalities", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los municipios',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listPersonTypes: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listPersonTypes", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los tipos de personalidad',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
				
				helpMessages: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getHelpMessages", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible obtener los mensajes de ayuda.',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },

                listAdditionalIndicators: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listAdditionalIndicators", {

                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los indicadores adicionaes',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                listCompanyValueChain: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listCompanyValueChain", {

                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar los indicadores adicionaes',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getCouncilSessions: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getCouncilSessions", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las sessiones de consejo',
                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getCouncilSessionCalls: function (councilSessionId) {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getCouncilSessionCalls", {
                        councilSessionId: councilSessionId
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No ha sido posible listar las sessiones de consejo',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                },
                getRelevantCalls: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getRelevantCalls", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las convocatorias',

                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getShowcaseCalls: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getShowcaseCalls", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las convocatorias',

                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getTrackingEstatusElement: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getTrackingEstatusElement", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las convocatorias',

                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getTypeCorrection: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getTypeCorrection", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las convocatorias',

                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },
                getMassiveSignatureCalls: function () {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/getMassiveSignatureCalls", {
                    }).success(function (data) {
                        defer.resolve(data);
                    }).error(function (data) {
                        var errorData = {
                            description: 'No ha sido posible listar las convocatorias',

                            data: data
                        };
                        defer.reject(errorData);
                    });

                    return defer.promise;
                },listRejectionReasonsByType: function (typeId) {
                    var defer = $q.defer();

                    $http.post(urlService.getBasePath() + "/api/v1/catalog/listRejectionReasonsByType", {
                        typeId: typeId
                    }).success(function (data) {
                            defer.resolve(data);
                        }).error(function (data) {
                            var errorData = {
                                description: 'No ha sido posible listar las razones de rechazo',
                                data: data
                            };
                            defer.reject(errorData);
                        });

                    return defer.promise;
                }, listEconomicSectors: function (idSectorType) {
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/listEconomicSectors", {
                  idSectorType: idSectorType
                }).success(function (data) {
                  defer.resolve(data);
                }).error(function (data) {
                  var errorData = {
                    description: 'No ha sido posible listar las razones de rechazo',
                    data: data
                  };
                  defer.reject(errorData);
                });

                return defer.promise;
              }, listEconomicSubsectors: function (idSector) {
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/listEconomicSubsectors", {
                  idSector: idSector
                }).success(function (data) {
                  defer.resolve(data);
                }).error(function (data) {
                  var errorData = {
                    description: 'No ha sido posible listar las razones de rechazo',
                    data: data
                  };
                  defer.reject(errorData);
                });

                return defer.promise;
              }, listEconomicBranch: function (idSubsector) {
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/listEconomicBranch", {
                  idSubsector: idSubsector
                }).success(function (data) {
                  defer.resolve(data);
                }).error(function (data) {
                  var errorData = {
                    description: 'No ha sido posible listar las razones de rechazo',
                    data: data
                  };
                  defer.reject(errorData);
                });

                return defer.promise;
              }, listExtraPointsTypes: function () {
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/listExtraPointsTypes")
                 .success(function (data) {
                  defer.resolve(data);
                }).error(function (data) {
                  var errorData = {
                    description: 'No ha sido posible listar los tipos de puntos extras',
                    data: data
                  };
                  defer.reject(errorData);
                });

                return defer.promise;
              }, listExtraPointsLevels: function () {
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/listExtraPointsLevels")
                  .success(function (data) {
                    defer.resolve(data);
                  }).error(function (data) {
                    var errorData = {
                      description: 'No ha sido posible listar los tipos de niveles para puntos extras',
                      data: data
                    };
                    defer.reject(errorData);
                  });

                return defer.promise;
              }, 
              listExtraPointsEvaluationTypes: function (){
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/listExtraPointsEvaluationTypes")
                  .success(function (data) {
                    defer.resolve(data);
                  }).error(function (data) {
                    var errorData = {
                      description: 'No ha sido posible listar los tipos de evaluacion para puntos extra',
                      data: data
                    };
                    defer.reject(errorData);
                  });

                return defer.promise;
              },
              getAllRifBillTypes: function (){
                var defer = $q.defer();

                $http.post(urlService.getBasePath() + "/api/v1/catalog/getAllRifBillTypes")
                  .success(function (data) {
                    defer.resolve(data);
                  }).error(function (data) {
                    var errorData = {
                      description: 'No ha sido posible listar las categorias de facturas para CREZCAMOS JUNTOS',
                      data: data
                    };
                    defer.reject(errorData);
                  });

                return defer.promise;
              }
            };
        });
}());
