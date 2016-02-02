'use strict';

describe('Service: accreditationService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var accreditationService;
  beforeEach(inject(function (_accreditationService_) {
    accreditationService = _accreditationService_;
  }));

  it('should do something', function () {
    expect(!!accreditationService).toBe(true);
  });

});
