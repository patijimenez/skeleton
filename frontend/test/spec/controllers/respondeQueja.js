'use strict';

describe('Controller: RespondequejaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RespondequejaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RespondequejaCtrl = $controller('RespondequejaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
