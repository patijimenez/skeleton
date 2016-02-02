'use strict';

describe('Controller: InstallationSessionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var InstallationSessionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    InstallationSessionCtrl = $controller('InstallationSessionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
