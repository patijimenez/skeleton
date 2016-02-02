'use strict';

describe('Controller: DashboardCounselorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DashboardCounselorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DashboardCounselorCtrl = $controller('DashboardCounselorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
