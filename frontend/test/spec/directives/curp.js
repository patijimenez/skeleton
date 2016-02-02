'use strict';

describe('Directive: curp', function () {
  beforeEach(module('fpymeFrontApp'));

  var element;

  it('should make hidden element visible', inject(function ($rootScope, $compile) {
    element = angular.element('<curp></curp>');
    element = $compile(element)($rootScope);
    expect(element.text()).toBe('this is the curp directive');
  }));
});
