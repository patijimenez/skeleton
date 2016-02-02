'use strict';

describe('Controller: UsuariosconfoliosrechazadosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var UsuariosconfoliosrechazadosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UsuariosconfoliosrechazadosCtrl = $controller('UsuariosconfoliosrechazadosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
