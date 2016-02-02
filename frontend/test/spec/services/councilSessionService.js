'use strict';

describe('Service: councilSessionService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var councilSessionService;
  beforeEach(inject(function (_councilSessionService_) {
    councilSessionService = _councilSessionService_;
  }));

  it('should do something', function () {
    expect(!!councilSessionService).toBe(true);
  });

});
