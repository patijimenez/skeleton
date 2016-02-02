'use strict';

describe('Controller: DashboardseguimientoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DashboardseguimientoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DashboardseguimientoCtrl = $controller('DashboardseguimientoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
