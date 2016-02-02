'use strict';

describe('Controller: JuridicoSolicitudCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var JuridicoSolicitudCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    JuridicoSolicitudCtrl = $controller('JuridicoSolicitudCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
