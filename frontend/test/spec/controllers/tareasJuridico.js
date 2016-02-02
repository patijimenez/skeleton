'use strict';

describe('Controller: TareasjuridicoCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var TareasjuridicoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TareasjuridicoCtrl = $controller('TareasjuridicoCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
