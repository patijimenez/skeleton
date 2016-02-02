'use strict';

describe('Controller: RevisaconvenioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RevisaconvenioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RevisaconvenioCtrl = $controller('RevisaconvenioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
