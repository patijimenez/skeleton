'use strict';

describe('Controller: ValidarTempUserCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ValidarTempUserCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ValidarTempUserCtrl = $controller('ValidarTempUserCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
