'use strict';

describe('Controller: EvaluacionseniorresultCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EvaluacionseniorresultCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EvaluacionseniorresultCtrl = $controller('EvaluacionseniorresultCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
