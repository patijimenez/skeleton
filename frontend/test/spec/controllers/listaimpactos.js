'use strict';

describe('Controller: ListaImpactosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaImpactosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaImpactosCtrl = $controller('ListaImpactosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
