'use strict';

describe('Controller: ListasolicitudreposicionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListasolicitudreposicionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListasolicitudreposicionCtrl = $controller('ListasolicitudreposicionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
