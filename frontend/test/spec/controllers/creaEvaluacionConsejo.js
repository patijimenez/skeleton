'use strict';

describe('Controller: CreaEvaluacionConsejoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CreaEvaluacionConsejoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CreaEvaluacionConsejoCtrl = $controller('CreaEvaluacionConsejoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
