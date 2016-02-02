'use strict';

describe('Controller: ConveniosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConveniosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConveniosCtrl = $controller('ConveniosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
