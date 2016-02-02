'use strict';

describe('Controller: ConvenioproveedoresCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConvenioproveedoresCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConvenioproveedoresCtrl = $controller('ConvenioproveedoresCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
