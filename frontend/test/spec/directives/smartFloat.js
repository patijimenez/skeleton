'use strict';

describe('Directive: smartFloat', function () {
  beforeEach(module('fpymeFrontApp'));

  var element;

  it('should make hidden element visible', inject(function ($rootScope, $compile) {
    element = angular.element('<smart-float></smart-float>');
    element = $compile(element)($rootScope);
    expect(element.text()).toBe('this is the smartFloat directive');
  }));
});
