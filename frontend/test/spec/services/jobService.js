'use strict';

describe('Service: jobService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var jobService;
  beforeEach(inject(function (_jobService_) {
    jobService = _jobService_;
  }));

  it('should do something', function () {
    expect(!!jobService).toBe(true);
  });

});
