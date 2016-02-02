'use strict';

describe('Controller: CapturaquejaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CapturaquejaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CapturaquejaCtrl = $controller('CapturaquejaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
