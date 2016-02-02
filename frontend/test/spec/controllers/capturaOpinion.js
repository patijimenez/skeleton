'use strict';

describe('Controller: CapturaopinionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CapturaopinionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CapturaopinionCtrl = $controller('CapturaopinionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
