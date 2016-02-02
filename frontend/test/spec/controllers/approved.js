'use strict';

describe('Controller: ApprovedCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ApprovedCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ApprovedCtrl = $controller('ApprovedCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
