'use strict';

describe('Service: developerService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var developerService;
  beforeEach(inject(function (_developerService_) {
    developerService = _developerService_;
  }));

  it('should do something', function () {
    expect(!!developerService).toBe(true);
  });

});
