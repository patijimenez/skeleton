'use strict';

describe('Controller: ListaministracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaministracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaministracionCtrl = $controller('ListaministracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
