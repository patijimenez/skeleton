'use strict';

describe('Service: fielService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var fielService;
  beforeEach(inject(function (_fielService_) {
    fielService = _fielService_;
  }));

  it('should do something', function () {
    expect(!!fielService).toBe(true);
  });

});
