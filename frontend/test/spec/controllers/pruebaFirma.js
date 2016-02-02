'use strict';

describe('Controller: PruebafirmaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PruebafirmaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PruebafirmaCtrl = $controller('PruebafirmaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
