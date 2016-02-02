'use strict';

describe('Controller: AgreementsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var AgreementsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AgreementsCtrl = $controller('AgreementsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
