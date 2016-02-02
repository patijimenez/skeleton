'use strict';

describe('Controller: ListaministracionpendientesCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaministracionpendientesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaministracionpendientesCtrl = $controller('ListaministracionpendientesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
