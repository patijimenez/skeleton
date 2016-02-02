'use strict';

describe('Controller: FirmadictamensolicitudCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmadictamensolicitudCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmadictamensolicitudCtrl = $controller('FirmadictamensolicitudCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
