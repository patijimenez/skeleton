'use strict';

describe('Controller: DetallecuestionarioconvocatoriadosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DetallecuestionarioconvocatoriadosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DetallecuestionarioconvocatoriadosCtrl = $controller('DetallecuestionarioconvocatoriadosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
