'use strict';

describe('Controller: ParticiparCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ParticiparCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ParticiparCtrl = $controller('ParticiparCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
