'use strict';

describe('Controller: ResponderalertaCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ResponderalertaCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ResponderalertaCtrl = $controller('ResponderalertaCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
