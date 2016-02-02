'use strict';

describe('Controller: RifreportevaluationdetailCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RifreportevaluationdetailCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RifreportevaluationdetailCtrl = $controller('RifreportevaluationdetailCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
