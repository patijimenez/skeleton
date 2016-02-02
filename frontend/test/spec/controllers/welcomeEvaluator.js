'use strict';

describe('Controller: WelcomeEvaluatorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var WelcomeEvaluatorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    WelcomeEvaluatorCtrl = $controller('WelcomeEvaluatorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
