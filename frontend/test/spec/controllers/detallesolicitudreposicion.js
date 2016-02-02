'use strict';

describe('Controller: DetallesolicitudreposicionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DetallesolicitudreposicionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DetallesolicitudreposicionCtrl = $controller('DetallesolicitudreposicionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
