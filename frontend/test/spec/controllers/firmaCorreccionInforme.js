'use strict';

describe('Controller: FirmacorreccioninformeCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmacorreccioninformeCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmacorreccioninformeCtrl = $controller('FirmacorreccioninformeCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
