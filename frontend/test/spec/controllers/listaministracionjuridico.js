'use strict';

describe('Controller: ListaministracionjuridicoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaministracionjuridicoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaministracionjuridicoCtrl = $controller('ListaministracionjuridicoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
