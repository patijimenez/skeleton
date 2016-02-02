'use strict';

describe('Controller: CajearValeCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CajearValeCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CajearValeCtrl = $controller('CajearValeCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
