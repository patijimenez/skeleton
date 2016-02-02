'use strict';

describe('Controller: ListaquejasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaquejasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaquejasCtrl = $controller('ListaquejasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
