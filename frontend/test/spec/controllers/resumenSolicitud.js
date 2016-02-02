'use strict';

describe('Controller: ResumenSolicitudCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ResumenSolicitudCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ResumenSolicitudCtrl = $controller('ResumenSolicitudCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
