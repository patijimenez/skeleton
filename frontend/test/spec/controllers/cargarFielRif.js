'use strict';

describe('Controller: CargarfielrifCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CargarfielrifCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CargarfielrifCtrl = $controller('CargarfielrifCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
