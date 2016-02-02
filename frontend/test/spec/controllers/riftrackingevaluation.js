'use strict';

describe('Controller: RiftrackingevaluationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RiftrackingevaluationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RiftrackingevaluationCtrl = $controller('RiftrackingevaluationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
