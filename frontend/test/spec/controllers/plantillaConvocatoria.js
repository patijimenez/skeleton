'use strict';

describe('Controller: PlantillaConvocatoriaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PlantillaConvocatoriaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PlantillaConvocatoriaCtrl = $controller('PlantillaConvocatoriaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
