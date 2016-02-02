'use strict';

describe('Controller: ConveniodetalleCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConveniodetalleCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConveniodetalleCtrl = $controller('ConveniodetalleCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
