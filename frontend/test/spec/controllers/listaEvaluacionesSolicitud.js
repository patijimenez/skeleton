'use strict';

describe('Controller: ListaEvaluacionesSolicitudCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaEvaluacionesSolicitudCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaEvaluacionesSolicitudCtrl = $controller('ListaEvaluacionesSolicitudCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
