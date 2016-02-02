'use strict';

describe('Controller: ListrifreportsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListrifreportsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListrifreportsCtrl = $controller('ListrifreportsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
