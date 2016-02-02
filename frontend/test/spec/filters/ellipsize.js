'use strict';

describe('Filter: ellipsize', function () {

  // load the filter's module
  beforeEach(module('fpymeFrontApp'));

  // initialize a new instance of the filter before each test
  var ellipsize;
  beforeEach(inject(function ($filter) {
    ellipsize = $filter('ellipsize');
  }));

  it('should return the input prefixed with "ellipsize filter:"', function () {
    var text = 'angularjs';
    expect(ellipsize(text)).toBe('ellipsize filter: ' + text);
  });

});
