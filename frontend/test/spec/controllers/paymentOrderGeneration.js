'use strict';

describe('Controller: PaymentordergenerationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var PaymentordergenerationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PaymentordergenerationCtrl = $controller('PaymentordergenerationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
