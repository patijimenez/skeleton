'use strict';

describe('Service: ministrationService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var ministrationService;
  beforeEach(inject(function (_ministrationService_) {
    ministrationService = _ministrationService_;
  }));

  it('should do something', function () {
    expect(!!ministrationService).toBe(true);
  });

});
