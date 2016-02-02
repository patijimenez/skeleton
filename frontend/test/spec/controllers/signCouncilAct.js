'use strict';

describe('Controller: SignCouncilActCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SignCouncilActCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SignCouncilActCtrl = $controller('SignCouncilActCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
