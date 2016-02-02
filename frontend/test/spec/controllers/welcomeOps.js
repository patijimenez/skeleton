'use strict';

describe('Controller: WelcomeOpsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var WelcomeOpsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    WelcomeOpsCtrl = $controller('WelcomeOpsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
