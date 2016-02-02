'use strict';

describe('Controller: ConvenioproveedordetalleCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConvenioproveedordetalleCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConvenioproveedordetalleCtrl = $controller('ConvenioproveedordetalleCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
