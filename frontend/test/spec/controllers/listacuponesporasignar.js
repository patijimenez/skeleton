'use strict';

describe('Controller: ListacuponesporasignarCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListacuponesporasignarCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListacuponesporasignarCtrl = $controller('ListacuponesporasignarCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
