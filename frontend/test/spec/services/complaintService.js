'use strict';

describe('Service: Complaintservice', function () {

  // load the service's module
  beforeEach(module('FpymeFrontApp'));

  // instantiate service
  var Complaintservice;
  beforeEach(inject(function (_Complaintservice_) {
    Complaintservice = _Complaintservice_;
  }));

  it('should do something', function () {
    expect(!!Complaintservice).toBe(true);
  });

});
