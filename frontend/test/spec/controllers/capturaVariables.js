'use strict';

describe('Controller: CapturavariablesCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CapturavariablesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CapturavariablesCtrl = $controller('CapturavariablesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
