'use strict';

describe('Controller: RifreportapplicantreviewCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var RifreportapplicantreviewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RifreportapplicantreviewCtrl = $controller('RifreportapplicantreviewCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
