'use strict';

describe('Directive: rfcMoral', function () {
  beforeEach(module('fpymeFrontApp'));

  var element;

  it('should make hidden element visible', inject(function ($rootScope, $compile) {
    element = angular.element('<rfc-moral></rfc-moral>');
    element = $compile(element)($rootScope);
    expect(element.text()).toBe('this is the rfcMoral directive');
  }));
});
