'use strict';

describe('Controller: ProductosproveedorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ProductosproveedorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProductosproveedorCtrl = $controller('ProductosproveedorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
