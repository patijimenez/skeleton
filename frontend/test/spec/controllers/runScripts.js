'use strict';

describe('Controller: RunScriptsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RunScriptsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RunScriptsCtrl = $controller('RunScriptsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
