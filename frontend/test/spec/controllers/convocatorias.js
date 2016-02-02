'use strict';

describe('Controller: ConvocatoriasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConvocatoriasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConvocatoriasCtrl = $controller('ConvocatoriasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
