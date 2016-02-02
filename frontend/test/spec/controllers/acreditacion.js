'use strict';

describe('Controller: AcreditacionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var AcreditacionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AcreditacionCtrl = $controller('AcreditacionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
