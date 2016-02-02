'use strict';

describe('Controller: BatchProcessEventsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var BatchProcessEventsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BatchProcessEventsCtrl = $controller('BatchProcessEventsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
