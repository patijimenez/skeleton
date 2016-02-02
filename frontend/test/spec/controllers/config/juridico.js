'use strict';

describe('Controller: ConfigJuridicoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConfigJuridicoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConfigJuridicoCtrl = $controller('ConfigJuridicoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
