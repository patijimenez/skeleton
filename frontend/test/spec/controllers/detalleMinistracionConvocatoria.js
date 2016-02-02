'use strict';

describe('Controller: DetalleministracionconvocatoriaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DetalleministracionconvocatoriaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DetalleministracionconvocatoriaCtrl = $controller('DetalleministracionconvocatoriaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
