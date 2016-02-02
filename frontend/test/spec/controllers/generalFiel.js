'use strict';

describe('Controller: GeneralFielCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var GeneralFielCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    GeneralFielCtrl = $controller('GeneralFielCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
