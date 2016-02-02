'use strict';

describe('Controller: ConfiguraimpactosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConfiguraimpactosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConfiguraimpactosCtrl = $controller('ConfiguraimpactosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
