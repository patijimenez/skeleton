'use strict';

describe('Controller: AsignacionManualCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var AsignacionManualCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AsignacionManualCtrl = $controller('AsignacionManualCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
