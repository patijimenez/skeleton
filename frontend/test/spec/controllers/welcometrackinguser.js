'use strict';

describe('Controller: WelcometrackinguserCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var WelcometrackinguserCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    WelcometrackinguserCtrl = $controller('WelcometrackinguserCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
