'use strict';

describe('Controller: ReporteBansefiCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ReporteBansefiCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ReporteBansefiCtrl = $controller('ReporteBansefiCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
