'use strict';

describe('Controller: PaymentordersCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PaymentordersCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PaymentordersCtrl = $controller('PaymentordersCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
