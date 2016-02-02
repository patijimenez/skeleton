'use strict';

describe('Controller: SignrifevaluationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SignrifevaluationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SignrifevaluationCtrl = $controller('SignrifevaluationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
