'use strict';

describe('Controller: AdministraReportesCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var AdministraReportesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdministraReportesCtrl = $controller('AdministraReportesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
