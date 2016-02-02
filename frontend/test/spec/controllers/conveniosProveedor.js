'use strict';

describe('Controller: ConveniosproveedorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConveniosproveedorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConveniosproveedorCtrl = $controller('ConveniosproveedorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
