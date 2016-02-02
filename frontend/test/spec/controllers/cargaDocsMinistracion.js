'use strict';

describe('Controller: CargaDocsMinistracionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CargaDocsMinistracionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CargaDocsMinistracionCtrl = $controller('CargaDocsMinistracionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
