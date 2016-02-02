'use strict';

describe('Controller: EvaluacionseguimientoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EvaluacionseguimientoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EvaluacionseguimientoCtrl = $controller('EvaluacionseguimientoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
