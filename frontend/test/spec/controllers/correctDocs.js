'use strict';

describe('Controller: CorrectDocsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CorrectDocsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CorrectDocsCtrl = $controller('CorrectDocsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
