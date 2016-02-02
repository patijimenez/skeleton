'use strict';

describe('Controller: ImpactsdialogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ImpactsdialogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ImpactsdialogCtrl = $controller('ImpactsdialogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
