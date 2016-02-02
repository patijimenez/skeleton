'use strict';

describe('Controller: GestionconvenioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var GestionconvenioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    GestionconvenioCtrl = $controller('GestionconvenioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
