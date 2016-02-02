'use strict';

describe('Controller: FirmaconvenioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var FirmaconvenioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FirmaconvenioCtrl = $controller('FirmaconvenioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
