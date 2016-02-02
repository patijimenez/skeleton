'use strict';

describe('Controller: ListaVitrinaSolicitudesFirmadasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaVitrinaSolicitudesFirmadasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaVitrinaSolicitudesFirmadasCtrl = $controller('ListaVitrinaSolicitudesFirmadasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
