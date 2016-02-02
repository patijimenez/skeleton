'use strict';

describe('Controller: EditcompanyCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EditcompanyCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EditcompanyCtrl = $controller('EditcompanyCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
