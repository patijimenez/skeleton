'use strict';

describe('Controller: DetallealertaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DetallealertaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DetallealertaCtrl = $controller('DetallealertaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
