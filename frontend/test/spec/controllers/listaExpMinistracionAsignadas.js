'use strict';

describe('Controller: ListaexpministracionasignadasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaexpministracionasignadasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaexpministracionasignadasCtrl = $controller('ListaexpministracionasignadasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
