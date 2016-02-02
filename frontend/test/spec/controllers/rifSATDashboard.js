'use strict';

describe('Controller: RifsatdashboardCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RifsatdashboardCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RifsatdashboardCtrl = $controller('RifsatdashboardCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
