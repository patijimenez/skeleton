'use strict';

describe('Service: Infotecservice', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var Infotecservice;
  beforeEach(inject(function (_Infotecservice_) {
    Infotecservice = _Infotecservice_;
  }));

  it('should do something', function () {
    expect(!!Infotecservice).toBe(true);
  });

});
