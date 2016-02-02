'use strict';

describe('Controller: SpentresourcedetailsdialogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SpentresourcedetailsdialogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SpentresourcedetailsdialogCtrl = $controller('SpentresourcedetailsdialogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
