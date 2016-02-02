'use strict';

describe('Controller: BatchProcessEventConsoleCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var BatchProcessEventConsoleCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BatchProcessEventConsoleCtrl = $controller('BatchProcessEventConsoleCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
