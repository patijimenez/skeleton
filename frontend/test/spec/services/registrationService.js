'use strict';

describe('Service: registrationService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var registrationService;
  beforeEach(inject(function (_registrationService_) {
    registrationService = _registrationService_;
  }));

  it('should do something', function () {
    expect(!!registrationService).toBe(true);
  });

});
