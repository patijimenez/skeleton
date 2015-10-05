/*global angular: true*/
(function () {
	'use strict';
  angular.module('fpymeFrontApp')
		.controller('RegisterCtrl', function ($scope, $dialog, $log, registrationService, catalogService, $location, $routeParams) {



			var handleRegisterError = function () {
				$scope.hideSubmit = false;
			};

			$scope.hideSubmit = false;

			catalogService.listStates().then(function (data) {
				$scope.states = data;
			});

			
			catalogService.helpMessages().then(function (data){
               $scope.messageHelp = data;
			});

    });
    angular.module('fpymeFrontApp').controller('TermDialogCtrl', function ($scope, dialog) {
      $scope.close = function () {
      	dialog.close();
      };
    });
}());


