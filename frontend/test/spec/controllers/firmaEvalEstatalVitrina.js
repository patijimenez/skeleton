'use strict';

describe('Controller: FirmaevalestatalvitrinaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmaevalestatalvitrinaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmaevalestatalvitrinaCtrl = $controller('FirmaevalestatalvitrinaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
