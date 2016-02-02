'use strict';

describe('Controller: UserdataCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var UserdataCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UserdataCtrl = $controller('UserdataCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
