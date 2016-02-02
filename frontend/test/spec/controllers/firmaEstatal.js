'use strict';

describe('Controller: FirmaEstatalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmaEstatalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmaEstatalCtrl = $controller('FirmaEstatalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
