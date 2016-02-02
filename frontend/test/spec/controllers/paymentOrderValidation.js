'use strict';

describe('Controller: PaymentordervalidationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PaymentordervalidationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PaymentordervalidationCtrl = $controller('PaymentordervalidationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
