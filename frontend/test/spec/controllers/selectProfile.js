'use strict';

describe('Controller: SelectprofileCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SelectprofileCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SelectprofileCtrl = $controller('SelectprofileCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
