'use strict';

describe('Controller: DemoinvocaservicioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DemoinvocaservicioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DemoinvocaservicioCtrl = $controller('DemoinvocaservicioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
