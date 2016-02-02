'use strict';

describe('Controller: ConveniobeneficiariovitrinaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConveniobeneficiariovitrinaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConveniobeneficiariovitrinaCtrl = $controller('ConveniobeneficiariovitrinaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
