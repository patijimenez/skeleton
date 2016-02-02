'use strict';

describe('Service: Responsecomplaintservice', function () {

  // load the service's module
  beforeEach(module('FpymeFrontApp'));

  // instantiate service
  var Responsecomplaintservice;
  beforeEach(inject(function (_Responsecomplaintservice_) {
    Responsecomplaintservice = _Responsecomplaintservice_;
  }));

  it('should do something', function () {
    expect(!!Responsecomplaintservice).toBe(true);
  });

});
