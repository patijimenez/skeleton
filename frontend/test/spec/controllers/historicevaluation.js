'use strict';

describe('Controller: HistoricevaluationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var HistoricevaluationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    HistoricevaluationCtrl = $controller('HistoricevaluationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
