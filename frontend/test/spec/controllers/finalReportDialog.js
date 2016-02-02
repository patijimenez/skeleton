'use strict';

describe('Controller: FinalreportdialogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FinalreportdialogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FinalreportdialogCtrl = $controller('FinalreportdialogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
