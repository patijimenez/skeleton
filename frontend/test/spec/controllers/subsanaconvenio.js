'use strict';

describe('Controller: SubsanaconvenioCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var SubsanaconvenioCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SubsanaconvenioCtrl = $controller('SubsanaconvenioCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
