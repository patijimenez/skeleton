'use strict';

describe('Controller: DashboardLegalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DashboardLegalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DashboardLegalCtrl = $controller('DashboardLegalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
