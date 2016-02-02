'use strict';

describe('Controller: VerdictamenCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var VerdictamenCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    VerdictamenCtrl = $controller('VerdictamenCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
