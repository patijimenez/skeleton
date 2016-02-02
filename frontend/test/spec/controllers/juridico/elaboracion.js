'use strict';

describe('Controller: JuridicoElaboracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var JuridicoElaboracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    JuridicoElaboracionCtrl = $controller('JuridicoElaboracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
