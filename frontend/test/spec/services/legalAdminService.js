'use strict';

describe('Service: legalAdminService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var legalAdminService;
  beforeEach(inject(function (_legalAdminService_) {
    legalAdminService = _legalAdminService_;
  }));

  it('should do something', function () {
    expect(!!legalAdminService).toBe(true);
  });

});
