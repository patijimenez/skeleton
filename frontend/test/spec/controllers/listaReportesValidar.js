'use strict';

describe('Controller: ListareportesvalidarCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListareportesvalidarCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListareportesvalidarCtrl = $controller('ListareportesvalidarCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
