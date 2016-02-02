'use strict';

describe('Controller: ListaaclaracionesevaluadorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaaclaracionesevaluadorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaaclaracionesevaluadorCtrl = $controller('ListaaclaracionesevaluadorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
