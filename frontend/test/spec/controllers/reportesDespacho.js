'use strict';

describe('Controller: ReportesdespachoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ReportesdespachoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ReportesdespachoCtrl = $controller('ReportesdespachoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
