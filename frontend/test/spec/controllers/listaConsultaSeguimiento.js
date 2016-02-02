'use strict';

describe('Controller: ListaConsultaSeguimientoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaConsultaSeguimientoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaConsultaSeguimientoCtrl = $controller('ListaConsultaSeguimientoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
