'use strict';

describe('Service: guiderService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var guiderService;
  beforeEach(inject(function (_guiderService_) {
    guiderService = _guiderService_;
  }));

  it('should do something', function () {
    expect(!!guiderService).toBe(true);
  });

});
