'use strict';

describe('Controller: ConveniosdesistidosCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var ConveniosdesistidosCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ConveniosdesistidosCtrl = $controller('ConveniosdesistidosCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
