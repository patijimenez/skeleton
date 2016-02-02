'use strict';

describe('Controller: FirmainformeseguimientoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmainformeseguimientoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmainformeseguimientoCtrl = $controller('FirmainformeseguimientoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
