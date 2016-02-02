'use strict';

describe('Controller: CouncilDetailCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CouncilDetailCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CouncilDetailCtrl = $controller('CouncilDetailCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
