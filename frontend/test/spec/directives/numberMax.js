'use strict';

describe('Directive: numberMax', function () {
  beforeEach(module('fpymeFrontApp'));

  var element;

  it('should make hidden element visible', inject(function ($rootScope, $compile) {
    element = angular.element('<number-max></number-max>');
    element = $compile(element)($rootScope);
    expect(element.text()).toBe('this is the numberMax directive');
  }));
});
