'use strict';

describe('Controller: ListaCuponesProveedoresCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListaCuponesProveedoresCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListaCuponesProveedoresCtrl = $controller('ListaCuponesProveedoresCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
