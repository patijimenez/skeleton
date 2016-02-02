'use strict';

describe('Controller: CallApprovedCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CallApprovedCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CallApprovedCtrl = $controller('CallApprovedCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
