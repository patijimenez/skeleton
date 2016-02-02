'use strict';

describe('Controller: CouncilsessionindividualvotesCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var CouncilsessionindividualvotesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CouncilsessionindividualvotesCtrl = $controller('CouncilsessionindividualvotesCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
