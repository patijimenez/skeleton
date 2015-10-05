'use strict';

angular.module('fpymeFrontApp')
  .controller('ChangePasswordCtrl', function ($scope, profileService) {
      $scope.disableSubmit = false;
      $scope.changePassword = function () {
          $scope.disableSubmit = true;
          profileService.changePassword($scope.password).then(function (data) {
              $scope.finished = true;
              $scope.showCorrect = true;
              $scope.disableSubmit = false;
          }, function () {
              //Error occured
              $scope.showIncorrect = true;
              $scope.disableSubmit = false;
          });
      };
      $scope.closeCorrect = function () {
          $scope.showCorrect = false;
      };
      $scope.closeIncorrect = function () {
          $scope.showIncorrect = false;
      };
  });
