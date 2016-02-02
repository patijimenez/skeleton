'use strict';

describe('Controller: ListaalertasevaluadorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaalertasevaluadorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaalertasevaluadorCtrl = $controller('ListaalertasevaluadorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
