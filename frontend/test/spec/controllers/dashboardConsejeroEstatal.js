'use strict';

describe('Controller: DashboardConsejeroEstatalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DashboardConsejeroEstatalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DashboardConsejeroEstatalCtrl = $controller('DashboardConsejeroEstatalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
