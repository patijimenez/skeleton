'use strict';

describe('Controller: UploadCouncilActCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var UploadCouncilActCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UploadCouncilActCtrl = $controller('UploadCouncilActCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
