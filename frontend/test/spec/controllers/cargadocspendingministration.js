'use strict';

describe('Controller: CargadocspendingministrationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CargadocspendingministrationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CargadocspendingministrationCtrl = $controller('CargadocspendingministrationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
