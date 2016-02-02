'use strict';

describe('Controller: SecretarioTecnicoDetalleCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SecretarioTecnicoDetalleCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SecretarioTecnicoDetalleCtrl = $controller('SecretarioTecnicoDetalleCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
