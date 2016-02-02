'use strict';

describe('Controller: ListaconveniosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaconveniosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaconveniosCtrl = $controller('ListaconveniosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
