'use strict';

describe('Service: agreementService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var agreementService;
  beforeEach(inject(function (_agreementService_) {
    agreementService = _agreementService_;
  }));

  it('should do something', function () {
    expect(!!agreementService).toBe(true);
  });

});
