'use strict';

describe('Controller: WelcomegeneraldataCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var WelcomegeneraldataCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    WelcomegeneraldataCtrl = $controller('WelcomegeneraldataCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
