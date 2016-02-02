'use strict';

describe('Service: modalityService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var modalityService;
  beforeEach(inject(function (_modalityService_) {
    modalityService = _modalityService_;
  }));

  it('should do something', function () {
    expect(!!modalityService).toBe(true);
  });

});
