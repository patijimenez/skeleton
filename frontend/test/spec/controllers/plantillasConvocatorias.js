'use strict';

describe('Controller: PlantillasConvocatoriasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PlantillasConvocatoriasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PlantillasConvocatoriasCtrl = $controller('PlantillasConvocatoriasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
