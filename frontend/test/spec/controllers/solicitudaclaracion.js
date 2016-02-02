'use strict';

describe('Controller: SolicitudaclaracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SolicitudaclaracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SolicitudaclaracionCtrl = $controller('SolicitudaclaracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
