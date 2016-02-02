'use strict';

describe('Controller: ListasolicitudreposicionevaluadorCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListasolicitudreposicionevaluadorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListasolicitudreposicionevaluadorCtrl = $controller('ListasolicitudreposicionevaluadorCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
