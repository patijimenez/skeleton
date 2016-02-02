'use strict';

describe('Controller: SesionesgrupoanalisisCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SesionesgrupoanalisisCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SesionesgrupoanalisisCtrl = $controller('SesionesgrupoanalisisCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
