'use strict';

describe('Controller: CallanalysisCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CallanalysisCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CallanalysisCtrl = $controller('CallanalysisCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
