'use strict';

describe('Controller: EvaluacionEstatalCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EvaluacionEstatalCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EvaluacionEstatalCtrl = $controller('EvaluacionEstatalCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
