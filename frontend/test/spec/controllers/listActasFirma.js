'use strict';

describe('Controller: ListactasfirmaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListactasfirmaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListactasfirmaCtrl = $controller('ListactasfirmaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
