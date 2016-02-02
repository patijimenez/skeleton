'use strict';

describe('Controller: SubsanarsolicitudCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SubsanarsolicitudCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SubsanarsolicitudCtrl = $controller('SubsanarsolicitudCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
