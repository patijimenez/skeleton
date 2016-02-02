'use strict';

describe('Directive: numbersOnly', function () {
  beforeEach(module('fpymeFrontApp'));

  var element;

  it('should make hidden element visible', inject(function ($rootScope, $compile) {
    element = angular.element('<numbers-only></numbers-only>');
    element = $compile(element)($rootScope);
    expect(element.text()).toBe('this is the numbersOnly directive');
  }));
});
