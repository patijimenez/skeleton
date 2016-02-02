'use strict';

describe('Directive: rfc', function () {
  beforeEach(module('fpymeFrontApp'));

  var element;

  it('should make hidden element visible', inject(function ($rootScope, $compile) {
    element = angular.element('<rfc></rfc>');
    element = $compile(element)($rootScope);
    expect(element.text()).toBe('this is the rfc directive');
  }));
});
