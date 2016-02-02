'use strict';

describe('Controller: BatchProcessBoardCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var BatchProcessBoardCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BatchProcessBoardCtrl = $controller('BatchProcessBoardCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
