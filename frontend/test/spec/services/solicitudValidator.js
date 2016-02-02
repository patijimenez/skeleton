'use strict';

describe('Service: solicitudValidator', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var solicitudValidator;
  beforeEach(inject(function (_solicitudValidator_) {
    solicitudValidator = _solicitudValidator_;
  }));

  it('should do something', function () {
    expect(!!solicitudValidator).toBe(true);
  });

});
