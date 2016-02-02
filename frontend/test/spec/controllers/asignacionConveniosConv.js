'use strict';

describe('Controller: AsignacionconveniosconvCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var AsignacionconveniosconvCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AsignacionconveniosconvCtrl = $controller('AsignacionconveniosconvCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
