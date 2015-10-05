'use strict';

angular.module('fpymeFrontApp')
  .controller('NewsCtrl', function ($scope, $location, messageService, profileService) {
    messageService.listCallMessages().then(function (data) {
      $scope.news = _.map(data, function (it) {
        return marked(it.message);
      });
    });
    $scope.closeNews = function () {
      profileService.hasSelectedProfile().then(function (data) {
        if(data.selected) {
            $location.path('/applicantDashboard');
        } else {
            $location.path('/selectProfile');
        }
      });
    };
  });
