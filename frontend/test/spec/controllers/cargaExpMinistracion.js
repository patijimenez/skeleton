'use strict';

describe('Controller: CargaexpministracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CargaexpministracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CargaexpministracionCtrl = $controller('CargaexpministracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
