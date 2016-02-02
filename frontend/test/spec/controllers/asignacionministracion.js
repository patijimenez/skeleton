'use strict';

describe('Controller: AsignacionministracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var AsignacionministracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AsignacionministracionCtrl = $controller('AsignacionministracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
