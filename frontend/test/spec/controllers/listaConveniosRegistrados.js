'use strict';

describe('Controller: ListaConveniosRegistradosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaConveniosRegistradosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaConveniosRegistradosCtrl = $controller('ListaConveniosRegistradosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
