'use strict';

describe('Service: Feedbackservice', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var Feedbackservice;
  beforeEach(inject(function (_Feedbackservice_) {
    Feedbackservice = _Feedbackservice_;
  }));

  it('should do something', function () {
    expect(!!Feedbackservice).toBe(true);
  });

});
