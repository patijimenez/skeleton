'use strict';

describe('Controller: WelcomeExternalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var WelcomeExternalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    WelcomeExternalCtrl = $controller('WelcomeExternalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
