'use strict';

describe('Service: urlService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var urlService;
  beforeEach(inject(function (_urlService_) {
    urlService = _urlService_;
  }));

  it('should do something', function () {
    expect(!!urlService).toBe(true);
  });

});
