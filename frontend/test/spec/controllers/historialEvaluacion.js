'use strict';

describe('Controller: HistorialevaluacionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var HistorialevaluacionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    HistorialevaluacionCtrl = $controller('HistorialevaluacionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
