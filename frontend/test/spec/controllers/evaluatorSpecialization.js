'use strict';

describe('Controller: EvaluatorSpecializationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EvaluatorSpecializationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EvaluatorSpecializationCtrl = $controller('EvaluatorSpecializationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
