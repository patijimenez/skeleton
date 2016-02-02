'use strict';

describe('Controller: ListaenrevisionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaenrevisionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaenrevisionCtrl = $controller('ListaenrevisionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
