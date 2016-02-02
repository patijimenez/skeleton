'use strict';

describe('Controller: ListaPorFirmarCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaPorFirmarCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaPorFirmarCtrl = $controller('ListaPorFirmarCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
