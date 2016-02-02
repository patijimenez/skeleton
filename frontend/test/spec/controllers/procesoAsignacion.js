'use strict';

describe('Controller: ProcesoAsignacionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ProcesoAsignacionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProcesoAsignacionCtrl = $controller('ProcesoAsignacionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
