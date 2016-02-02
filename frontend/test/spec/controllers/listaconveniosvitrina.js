'use strict';

describe('Controller: ListaconveniosvitrinaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaconveniosvitrinaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaconveniosvitrinaCtrl = $controller('ListaconveniosvitrinaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
