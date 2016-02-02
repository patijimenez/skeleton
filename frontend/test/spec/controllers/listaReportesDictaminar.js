'use strict';

describe('Controller: ListareportesdictaminarCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListareportesdictaminarCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListareportesdictaminarCtrl = $controller('ListareportesdictaminarCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
