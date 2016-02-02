'use strict';

describe('Controller: PaymentorderdialogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PaymentorderdialogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PaymentorderdialogCtrl = $controller('PaymentorderdialogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
