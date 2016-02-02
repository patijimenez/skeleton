'use strict';

describe('Controller: ApplicationdocshistoryCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ApplicationdocshistoryCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ApplicationdocshistoryCtrl = $controller('ApplicationdocshistoryCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
