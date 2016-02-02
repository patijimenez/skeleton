'use strict';

describe('Controller: ResponderalertaevaluadorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ResponderalertaevaluadorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ResponderalertaevaluadorCtrl = $controller('ResponderalertaevaluadorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
