'use strict';

describe('Controller: EvaluacionseniordetalleCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EvaluacionseniordetalleCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EvaluacionseniordetalleCtrl = $controller('EvaluacionseniordetalleCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
