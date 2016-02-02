'use strict';

describe('Controller: BusquedaMinistracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var BusquedaMinistracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BusquedaMinistracionCtrl = $controller('BusquedaMinistracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
