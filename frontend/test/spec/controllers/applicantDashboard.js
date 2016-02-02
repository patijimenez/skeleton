'use strict';

describe('Controller: ApplicantDashboardCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ApplicantDashboardCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ApplicantDashboardCtrl = $controller('ApplicantDashboardCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
