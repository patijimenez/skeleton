'use strict';

describe('Controller: GeneratedocumentsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var GeneratedocumentsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    GeneratedocumentsCtrl = $controller('GeneratedocumentsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
