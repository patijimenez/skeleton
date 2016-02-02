'use strict';

describe('Controller: VistaseguimientofinalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var VistaseguimientofinalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    VistaseguimientofinalCtrl = $controller('VistaseguimientofinalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
