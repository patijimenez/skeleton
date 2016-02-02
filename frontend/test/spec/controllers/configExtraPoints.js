'use strict';

describe('Controller: ConfigextrapointsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConfigextrapointsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConfigextrapointsCtrl = $controller('ConfigextrapointsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
