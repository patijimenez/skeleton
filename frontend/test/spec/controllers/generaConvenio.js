'use strict';

describe('Controller: GeneraConvenioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var GeneraConvenioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    GeneraConvenioCtrl = $controller('GeneraConvenioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
