'use strict';

describe('Service: loggedService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var loggedService;
  beforeEach(inject(function (_loggedService_) {
    loggedService = _loggedService_;
  }));

  it('should do something', function () {
    expect(!!loggedService).toBe(true);
  });

});
