'use strict';

describe('Controller: FirmaconvenioproveedorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmaconvenioproveedorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmaconvenioproveedorCtrl = $controller('FirmaconvenioproveedorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
