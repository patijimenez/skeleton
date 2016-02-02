'use strict';

describe('Service: Surveyservice', function () {

  // load the service's module
  beforeEach(module('FpymeFrontApp'));

  // instantiate service
  var Surveyservice;
  beforeEach(inject(function (_Surveyservice_) {
    Surveyservice = _Surveyservice_;
  }));

  it('should do something', function () {
    expect(!!Surveyservice).toBe(true);
  });

});
