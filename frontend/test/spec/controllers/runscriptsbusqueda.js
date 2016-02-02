'use strict';

describe('Controller: RunscriptsbusquedaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RunscriptsbusquedaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RunscriptsbusquedaCtrl = $controller('RunscriptsbusquedaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
