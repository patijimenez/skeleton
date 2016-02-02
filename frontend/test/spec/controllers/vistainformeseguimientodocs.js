'use strict';

describe('Controller: VistainformeseguimientodocsCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var VistainformeseguimientodocsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    VistainformeseguimientodocsCtrl = $controller('VistainformeseguimientodocsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
