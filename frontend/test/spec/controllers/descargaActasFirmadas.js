'use strict';

describe('Controller: DescargaactasfirmadasCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var DescargaactasfirmadasCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DescargaactasfirmadasCtrl = $controller('DescargaactasfirmadasCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
