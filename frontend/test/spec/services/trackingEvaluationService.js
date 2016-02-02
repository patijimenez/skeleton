'use strict';

describe('Service: Trackingevaluationservice', function () {

  // load the service's module
  beforeEach(module('FpymeFrontApp'));

  // instantiate service
  var Trackingevaluationservice;
  beforeEach(inject(function (_Trackingevaluationservice_) {
    Trackingevaluationservice = _Trackingevaluationservice_;
  }));

  it('should do something', function () {
    expect(!!Trackingevaluationservice).toBe(true);
  });

});
