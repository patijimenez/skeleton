'use strict';

describe('Controller: ResponderaclaracionesCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ResponderaclaracionesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ResponderaclaracionesCtrl = $controller('ResponderaclaracionesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
