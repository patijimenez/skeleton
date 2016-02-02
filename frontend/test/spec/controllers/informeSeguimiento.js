'use strict';

describe('Controller: InformeSeguimientoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var InformeSeguimientoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    InformeSeguimientoCtrl = $controller('InformeSeguimientoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
