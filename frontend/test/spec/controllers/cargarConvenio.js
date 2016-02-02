'use strict';

describe('Controller: CargarConvenioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CargarConvenioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CargarConvenioCtrl = $controller('CargarConvenioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
