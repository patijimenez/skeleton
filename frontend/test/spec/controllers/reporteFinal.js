'use strict';

describe('Controller: ReportefinalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ReportefinalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ReportefinalCtrl = $controller('ReportefinalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
