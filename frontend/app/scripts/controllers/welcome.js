(function () {
  'use strict';

  angular.module('fpymeFrontApp')
    .controller('WelcomeCtrl', function ($scope, $log, $location, profileService, fielService, registrationService, catalogService, urlService) {

      $scope.baseUrl = urlService.getBasePath();
      $scope.isRIF = false;
      $scope.selectedBansefiOffice = null;
      $scope.disableRifButtons = false;
      $scope.rifSAT = false;
      $scope.fielIndividualError = false;
      $scope.rfcExists = false;
      $scope.rfcExistsAndIsAllowed = false;
      $scope.isAllowedToSaveFiel = false;
      $scope.allowedToDuplicateRFC = false;

      //Catalogs
      catalogService.listCompanyProfileTypes().then(function (data) {
        $scope.companyProfileTypes = data;
      });

      catalogService.listStates().then(function (data) {
        $scope.states = data;
      });

      catalogService.listStratifications().then(function (data) {
        $scope.stratifications = data;
      });

      catalogService.listOtherTypes().then(function (data) {
        $scope.otherTypes = data;
      });

      catalogService.listGovernmentTypes().then(function (data) {
        $scope.governmentTypes = data;
      });

      catalogService.listIndividualTypes().then(function (data) {
        $scope.individualTypes = data;
      });
	  
	  catalogService.helpMessages().then(function (data){
        $scope.messageHelp = data;
	  });

      $scope.$watch('government.state', function () {
        $scope.municipalities = [];
        if ($scope.government && $scope.government.state) {
          catalogService.listMunicipalities($scope.government.state).then(function (data) {
            $scope.municipalities = data;
          });
        } else {
          $scope.municipalities = [];
        }
      });

      //General
      $scope.showSomething = false;
      $scope.$watch('profile', function () {
        if ($scope.profile) {
          if ($scope.profileType === 'student' && $scope.profile.address && !$scope.profile.finishedProfile) {
            
            $scope.step = 'complement';
          } else if ($scope.profileType !== 'student' && $scope.profileType !== 'government' && !$scope.profile.fiel) {
            if ($scope.profile.address && $scope.profileType == 'individual' && $scope.individual.rifSAT) {
              $scope.step = 'rifSAT';
            } else if (!$scope.profile.address && ($scope.profileType == 'individual' && $scope.individual.rifSAT)) {
              $scope.step = 'address';
            } else {
              $scope.step = 'startup';
            }
          } else if (!$scope.profile.address) {
            $scope.step = 'address';
          } else if (!$scope.profile.finishedProfile) {
            $scope.step = 'complement';
          } else {
            profileService.hasSelectedProfile().then(function (data) {
              if (data.selected) {
                $location.path('/applicantDashboard');
              } else {
                $location.path('/selectProfile');
              }
            });
          }
          $scope.showSomething = true;
        }
      });

      profileService.getApplicantData().then(function (data) {
        if (data.type === 'Física') {
          $scope.profileType = 'individual';
          $scope.individual = data;
        } else if (data.type === 'Estudiante') {
          $scope.profileType = 'student';
          $scope.student = data;
        } else if (data.type === 'Gobierno') {
          $scope.profileType = 'government';
          $scope.government = data;
        } else if (data.type === 'Moral') {
          $scope.profileType = 'company';
          $scope.company = data;
        } else if (data.type === 'Otro') {
          $scope.profileType = 'other';
          $scope.other = data;
        }

        if (data.personType && data.personType.name == 'Régimen de Incorporación Fiscal') {
          $scope.isRIF = true;
        }
        if ($scope.profileType == 'individual' && $scope.individual.rifSAT) {
          $scope.getBansefiOffices();
          $scope.checkSatDocuments();
          $scope.rifSAT = true;
        }

        if ($scope.individual && $scope.individual.personType.name === 'Persona física con actividad empresarial') {
          $scope.showSkipFIEL = true;
        }

        $scope.profile = data;
        $log.log($scope.profile);
        $scope.allowedToDuplicateRFC = $scope.profile.allowDuplicateRFC;
      });

      //FIEL
			$scope.showFiel = function () {
				if ($scope.profileType !== 'student' && $scope.profileType !== 'government' && $scope.isRIF == false) {
          $scope.step = 'fiel';
        } else if (!$scope.profile.address) {
          $scope.step = 'address';
        } else {
          $scope.step = 'complement';
        }
      };

      $scope.canSaveFiel = function () {
        var fiel, subject, profile;

        fiel = $scope.fiel;
        subject = $scope.subject;
        profile = $scope.profile;

        return fiel && !fiel.expired && !fiel.notYetValid && subject.rfc === profile.rfc;
      };


      $scope.canSaveCompanyFiel = function () {
        var fiel, companySubject, profile;

        fiel = $scope.fiel;
        companySubject = $scope.companySubject;
        profile = $scope.profile;

        return fiel && !fiel.expired && !fiel.notYetValid && companySubject && companySubject.rfc === profile.rfc;
      };

      $scope.saveCompanyFiel = function () {
        if ($scope.canSaveCompanyFiel()) {
          fielService.saveCompanyUploaded().then(function (data) {
            $scope.profile.individualCurp = $scope.companySubject.individualCurp;
            $scope.profile.individualRfc = $scope.companySubject.individualRfc;
            $scope.step = 'address';
          });
        }
      };

      $scope.saveFiel = function () {
        if ($scope.canSaveFiel()) {
          fielService.saveUploaded().then(function (data) {
            $scope.profile.curp = $scope.subject.serial;
            if ($scope.profile.address) {
              $scope.step = 'complement';
            } else {
              $scope.step = 'address';
            }
          });
        }
      };

      $scope.actualizaCompanyRfc = function () {
        fielService.useCompanyUploadedRfc().then(function () {
          $scope.profile.rfc = $scope.companySubject.rfc;
        });
      };

      $scope.checkRfcExists = function(rfc){
        $log.log("Checanco el rfc ...");
        registrationService.rfcExists(rfc, null).then(function(result) {
          $scope.rfcExists = result.exists;
          $log.log("rfcExists: ", $scope.rfcExists);
          $log.log("allowedToDuplicateRFC: ", $scope.allowedToDuplicateRFC);

          if($scope.rfcExists == true && $scope.allowedToDuplicateRFC == true) {
            $scope.isAllowedAndRfcDoesntExists = true;
            $scope.rfcExistsAndIsAllowed = true;
          } else if($scope.rfcExists == true && $scope.allowedToDuplicateRFC == false) {
            $scope.isAllowedAndRfcDoesntExists = false;
            $scope.rfcExistsAndIsAllowed = false;
          } else if($scope.rfcExists == false && $scope.allowedToDuplicateRFC == true) {
            $scope.isAllowedAndRfcDoesntExists = true;
            $scope.rfcExistsAndIsAllowed = false;
          } else if($scope.rfcExists == false && $scope.allowedToDuplicateRFC == false) {
            $scope.isAllowedAndRfcDoesntExists = true;
            $scope.rfcExistsAndIsAllowed = false;
          } else {
            $scope.isAllowedAndRfcDoesntExists = false;
            $scope.rfcExistsAndIsAllowed = false;
          } 

          if($scope.rfcExists == false && $scope.changeFiel){
            $scope.isAllowedToSaveFiel = true;
          } else if($scope.rfcExists == false && !$scope.changeFiel){
            $scope.isAllowedToSaveFiel = true;
          } else if($scope.rfcExists == true && $scope.changeFiel){
            $scope.isAllowedToSaveFiel = true;
          } else if($scope.rfcExists == true && !$scope.changeFiel){
            $scope.isAllowedToSaveFiel = true;
          } else {
            $scope.isAllowedToSaveFiel = false;
          }

          $log.log("rfcExistsAndIsAllowed", $scope.rfcExistsAndIsAllowed);
        });
      };

      $scope.actualizaRfc = function () {
        fielService.useUploadedRfc($scope.subject).then(function () {
          $scope.profile.rfc = $scope.subject.rfc;
        });
      };

      $scope.fielError = false;
      $scope.fielCompanyError = false;
      $scope.uploadComplete = function (content, completed) {
        $scope.fielIndividualError = false;
        $scope.fielCompanyError = false;
        var obj;
        if (completed && content.length > 0) {

          obj = JSON.parse(content);
          $scope.fiel = obj;
          if (obj.subject) {
            $scope.subject = obj.subject;
            $scope.fielError = false;
          } else {
            $scope.subject = null;
            $scope.fielError = true;
          }

          if (obj.subject && ($scope.profileType === 'company' || $scope.profileType === 'other')) {
            if (obj.subject.rfc.indexOf("/") >= 0) {
              var parts = obj.subject.rfc.split("/");
              var curpParts = obj.subject.serial.split("/");
              $scope.companySubject = {
                rfc: parts[0].trim(),
                individualRfc: parts[1].trim(),
                individualCurp: curpParts[1].trim()
              };
            } else {
              $scope.subject = null;
              $scope.fielCompanyError = true;
            }

            $scope.checkRfcExists($scope.companySubject.rfc);
          }

          if ($scope.subject && $scope.profileType === 'individual') {
            if (obj.subject.rfc.indexOf("/") >= 0) {
              $scope.fielIndividualError = true;
            } else {
              $scope.fielIndividualError = false;
              spitNameIndividual()
            }

            $scope.checkRfcExists(obj.subject.rfc);

            if ($scope.individual.personType.name === 'Persona física con actividad empresarial') {
              profileService.updateProfileWithFIEL().then(function (data) {
                if (data) {
                  $log.info(data);
                } else {
                  $log.info('Error al actualizar tus datos de perfil');
                }
              });
            }
          }
        }
      };

      $scope.uploadQrComplete = function (content, completed) {
        var result;
        if (completed && content.length > 0) {
          result = JSON.parse(content);
          if (result.status) {
            $scope.qrErrorMessage = null;
          } else {
            $scope.qrErrorMessage = result.errorMessage;
          }
        }
      };

      function spitNameIndividual() {
        var names = $scope.subject.name.split(" ");
        $scope.subject.lastName1 = names[names.length - 2];
        $scope.subject.lastName2 = names[names.length - 1];

        $scope.subject.firstName = '';
        for (var i = 0; i < names.length - 2; i++) {
          $scope.subject.firstName = $scope.subject.firstName + ' ' + names[i];
        }
      }

      //Dirección
      $scope.disableSubmitAddress = false;
      catalogService.listSettlementTypes().then(function (data) {
        $scope.settlementType = data;
      });

      catalogService.listStates().then(function (data) {
        $scope.states = data;
      });

      catalogService.listRoadTypes().then(function (data) {
        $scope.roadTypes = data;
      });

      $scope.$watch('address.state', function () {
        if ($scope.address && $scope.address.state) {
          catalogService.listMunicipalities($scope.address.state).then(function (data) {
            $scope.municipalities = data;
          });
        } else {
          $scope.municipalities = [];
        }
      });

      $scope.$watch('address.postalCode', function () {
        if ($scope.address && $scope.address.postalCode) {
          catalogService.listPostalSettlements($scope.address.postalCode).then(function (data) {
            $scope.possibleSettlements = data;
            if (data.length > 0) {
              $scope.showPossibleSettlements = true;
            } else {
              $scope.showPossibleSettlements = false;
            }
          });
        }
      });

      $scope.closePossibleSettlements = function () {
        $scope.showPossibleSettlements = false;
      };

      $scope.prefillSettlement = function (settlementId) {
        catalogService.showSettlementData(settlementId).then(function (data) {
          $scope.showPossibleSettlements = false;
          $scope.possibleSettlement = data;
          $scope.address.settlementId = settlementId;
          $scope.address.settlement = data.name;
          $scope.address.settlementType = data.settlementType.id;
          $scope.address.state = data.state.id;
          $scope.address.municipality = data.municipality.id;
          $scope.address.locality = null;
          $scope.possibleLocalities = data.localities;
        });
      };

      $scope.submitAddress = function (address) {
        $scope.disableSubmitAddress = true;
        address.latitude = $scope.latitude;
        address.longitude = $scope.longitude;
        profileService.saveAddress(address).then(function (data) {
          if (scrollTo) {
            scrollTo(0, 0);
          }
          $scope.disableSubmitAddress = false;
          if ($scope.profileType == 'individual' && $scope.individual.rifSAT) {
            $scope.step = 'rifSAT';
          } else {
            $scope.step = 'complement';
          }
        }, function () {
          $scope.disableSubmitAddress = false;
        });
      };

      $scope.updateIndividual = function () {
        profileService.updateIndividualData($scope.individual).then(function (data) {
          profileService.hasSelectedProfile().then(function (data) {
            if (data.selected) {
              $location.path('/applicantDashboard');
            } else {
              $location.path('/selectProfile');
            }
          });
        });
      };

      $scope.updateCompany = function () {
        profileService.updateCompanyData($scope.company).then(function (data) {
          profileService.hasMissingStratification().then(function (data) {
            if (data.missing) {
              $location.path('/welcomeGeneralData');
            } else {
              profileService.hasSelectedProfile().then(function (data) {
                if (data.selected) {
                  $location.path('/applicantDashboard');
                } else {
                  $location.path('/selectProfile');
                }
              });
            }
          });
        });
      };

      $scope.updateGovernment = function () {
        profileService.updateGovernmentData($scope.government).then(function (data) {
          profileService.hasMissingStratification().then(function (data) {
            if (data.missing) {
              $location.path('/welcomeGeneralData');
            } else {
              profileService.hasSelectedProfile().then(function (data) {
                if (data.selected) {
                  $location.path('/applicantDashboard');
                } else {
                  $location.path('/selectProfile');
                }
              });
            }
          });
        });
      };

      $scope.updateOther = function () {
        profileService.updateOtherData($scope.other).then(function (data) {
          // $location.path('/welcomeGeneralData');   //Vista de estratificacion
          profileService.hasSelectedProfile().then(function (data) {
            if (data.selected) {
              $location.path('/applicantDashboard');
            } else {
              $location.path('/selectProfile');
            }
          });
        });
      };

      $scope.prefillStreet = function () {
        $scope.address.mainRoad = $scope.street;
        $scope.street = '';
      };

      var geocoder = new google.maps.Geocoder()
      var geocode = function (results, status) {
        if (results) {
          $scope.possibleAdresses = results;
          if (results.length > 0) {
            var street = "";
            if (results[0].address_components.length > 1 && results[0].address_components[1].types[0] == "route") {
              street = results[0].address_components[1].short_name;
              $scope.street = street;
              $scope.$digest();
            } else if (results[0].address_components.length > 0 && results[0].address_components[0].types[0] == "route") {
              street = results[0].address_components[0].short_name;
              $scope.street = street;
              $scope.$digest();
            } else {
              $scope.street = "";
            }
          } else {
            $scope.street = "";
          }
        } else {
          $scope.street = "";
        }
      };
      $scope.$watch('address.locality', function () {
        if ($scope.address) {
          var localityId = $scope.address.locality;
          var locality;
          if (localityId) {
            locality = _.find($scope.possibleLocalities, function (l) {
              return l.id == localityId;
            });
            var latLng = new google.maps.LatLng(locality.latitude, locality.longitude);
            var mapOptions = {
              center: new google.maps.LatLng(locality.latitude, locality.longitude),
              zoom: 14,
              mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map-canvas"),
              mapOptions);
            var marker = new google.maps.Marker({
              map: map,
              position: latLng
            });
            geocoder.geocode({'latLng': latLng}, geocode);
            $scope.latitude = latLng.lat();
            $scope.longitude = latLng.lng();
            google.maps.event.addListener(map, 'click', function (event) {
              marker.setMap(null);
              $scope.latitude = event.latLng.lat();
              $scope.longitude = event.latLng.lng();
              marker = new google.maps.Marker({
                map: map,
                position: event.latLng
              })
              geocoder.geocode({'latLng': event.latLng}, geocode);

            });
          }
        }
      });

      $scope.$watch('government.governmentType', function () {
        var municipalityTypes = ['Gobierno Municipal', 'Banca de desarrollo municipal'];
        var stateTypes = ['Gobierno Municipal', 'Gobierno Estatal', 'Secretaría del Gobierno del Estado'];
        if ($scope.government && $scope.government.governmentType) {
          var governmentType = parseInt($scope.government.governmentType, 10);
          var selectedGovernmentType = _.find($scope.governmentTypes, function (type) {
            return type.id === governmentType;
          });
          $scope.showMunicipality = _.contains(municipalityTypes, selectedGovernmentType.name);
          $scope.showState = _.contains(stateTypes, selectedGovernmentType.name);
        }
      });

      $scope.uploadQrComplete = function (content, completed) {
        var obj;
        if (completed && content.length > 0) {
          obj = JSON.parse(content);
          if (obj.status) {
            if (obj.uploaded) {
              $scope.satDocs = {
                status: true,
                documents: obj.documents
              };
              $scope.qrErrorMessage = null;
            } else {
              $scope.qrErrorMessage = "Error al cargar los documentos";
            }
          } else {
            $scope.qrErrorMessage = obj.errorMessage ? obj.errorMessage : "Error al cargar los documentos";
          }
        }
      };

      $scope.completeSatRifRegister = function () {
        $scope.errorMessage = null;
        $scope.disableRifButtons = true;
        profileService.completeSatRifRegister($scope.selectedBansefiOffice.num_office).then(function (result) {
          if (result.status) {
            profileService.hasSelectedProfile().then(function (data) {
              if (data.selected) {
                $location.path('/rifSATDashboard');
              } else {
                $location.path('/selectProfile');
              }
            });
          } else {
            $scope.disableRifButtons = false;
            $scope.qrErrorMessage = "Error al completar el registro";
          }
        }, function () {
          $scope.qrErrorMessage = "Error al completar el registro";
          $scope.disableRifButtons = false;
        });
      };

      $scope.getBansefiOffices = function () {
        profileService.getBansefiOffices().then(function (data) {
          $scope.bansefiOffices = data;
        });
      };

      $scope.checkSatDocuments = function () {
        profileService.checkSatDocuments().then(function (data) {
          $scope.satDocs = data;
        });
      };

      $scope.changeSatDocs = function () {
        $scope.satDocs = { status: false };
      };

      $scope.bansefiOfficeClick = function (office) {
        $scope.selectedBansefiOffice = office;
      };

      /**
       *
       */
      $scope.skipFiel = function () {
        profileService.updateProfileWithoutFIEL().then(function (data) {
          if (data) {
            $log.info(data);
            if ($scope.profile.address) {
              $scope.step = 'complement';
            } else {
              $scope.step = 'address';
            }
          } else {
            $log.info('Error al actualizar tus datos de perfil');
          }
        });

      };

    });
}());
