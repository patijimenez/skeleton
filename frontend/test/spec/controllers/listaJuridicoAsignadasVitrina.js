'use strict';

describe('Controller: ListajuridicoasignadasvitrinaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ListajuridicoasignadasvitrinaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ListajuridicoasignadasvitrinaCtrl = $controller('ListajuridicoasignadasvitrinaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
