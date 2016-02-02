'use strict';

describe('Controller: VistaImpactoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var VistaImpactoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    VistaImpactoCtrl = $controller('VistaImpactoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
