'use strict';

describe('Controller: ReportesasignadosevaluacionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ReportesasignadosevaluacionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ReportesasignadosevaluacionCtrl = $controller('ReportesasignadosevaluacionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
