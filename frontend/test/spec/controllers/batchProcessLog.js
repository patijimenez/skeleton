'use strict';

describe('Controller: BatchProcessLogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var BatchProcessLogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BatchProcessLogCtrl = $controller('BatchProcessLogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
