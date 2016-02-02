'use strict';

describe('Controller: DashboardCounselorDetailCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DashboardCounselorDetailCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DashboardCounselorDetailCtrl = $controller('DashboardCounselorDetailCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
