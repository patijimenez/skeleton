'use strict';

describe('Controller: ReportesasignadosvalidacionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ReportesasignadosvalidacionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ReportesasignadosvalidacionCtrl = $controller('ReportesasignadosvalidacionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
