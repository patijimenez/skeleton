'use strict';

describe('Directive: statalDetail', function () {

  // load the directive's module
  beforeEach(module('fpymeFrontApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<statal-detail></statal-detail>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the statalDetail directive');
  }));
});
