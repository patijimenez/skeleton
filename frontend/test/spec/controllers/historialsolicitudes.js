'use strict';

describe('Controller: HistorialsolicitudesCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var HistorialsolicitudesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    HistorialsolicitudesCtrl = $controller('HistorialsolicitudesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
