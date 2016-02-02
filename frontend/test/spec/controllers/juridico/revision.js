'use strict';

describe('Controller: JuridicoRevisionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var JuridicoRevisionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    JuridicoRevisionCtrl = $controller('JuridicoRevisionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});