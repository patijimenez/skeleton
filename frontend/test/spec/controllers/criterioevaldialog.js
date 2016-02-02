'use strict';

describe('Controller: CriterioevaldialogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CriterioevaldialogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CriterioevaldialogCtrl = $controller('CriterioevaldialogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
