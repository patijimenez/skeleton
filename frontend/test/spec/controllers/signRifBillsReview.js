'use strict';

describe('Controller: SignrifbillsreviewCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SignrifbillsreviewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SignrifbillsreviewCtrl = $controller('SignrifbillsreviewCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
