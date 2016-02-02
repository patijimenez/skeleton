'use strict';

describe('Controller: SesionHistoricaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SesionHistoricaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SesionHistoricaCtrl = $controller('SesionHistoricaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
