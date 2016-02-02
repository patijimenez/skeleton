'use strict';

describe('Controller: ListaAsignadasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaAsignadasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaAsignadasCtrl = $controller('ListaAsignadasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
