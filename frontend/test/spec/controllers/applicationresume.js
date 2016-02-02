'use strict';

describe('Controller: ApplicationresumeCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ApplicationresumeCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ApplicationresumeCtrl = $controller('ApplicationresumeCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
