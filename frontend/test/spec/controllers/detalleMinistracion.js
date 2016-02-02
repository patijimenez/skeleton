'use strict';

describe('Controller: DetalleministracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DetalleministracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DetalleministracionCtrl = $controller('DetalleministracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
