'use strict';

describe('Controller: EditDocumentDialogCtrl', function () {

  // load the controller's module
  beforeEach(module('fpymeFrontApp'));

  var EditDocumentDialogCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EditDocumentDialogCtrl = $controller('EditDocumentDialogCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
