'use strict';

describe('Controller: DetallejuridicoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DetallejuridicoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DetallejuridicoCtrl = $controller('DetallejuridicoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
