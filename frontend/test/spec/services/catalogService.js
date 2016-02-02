'use strict';

describe('Service: catalogService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var catalogService;
  beforeEach(inject(function (_catalogService_) {
    catalogService = _catalogService_;
  }));

  it('should do something', function () {
    expect(!!catalogService).toBe(true);
  });

});
