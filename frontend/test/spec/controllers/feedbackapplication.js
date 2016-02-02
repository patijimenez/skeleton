'use strict';

describe('Controller: FeedbackapplicationCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FeedbackapplicationCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FeedbackapplicationCtrl = $controller('FeedbackapplicationCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
