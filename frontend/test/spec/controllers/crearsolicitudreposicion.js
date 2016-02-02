'use strict';

describe('Controller: CrearsolicitudreposicionCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CrearsolicitudreposicionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CrearsolicitudreposicionCtrl = $controller('CrearsolicitudreposicionCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
