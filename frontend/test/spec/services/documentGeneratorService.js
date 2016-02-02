'use strict';

describe('Service: documentGeneratorService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var documentGeneratorService;
  beforeEach(inject(function (_documentGeneratorService_) {
    documentGeneratorService = _documentGeneratorService_;
  }));

  it('should do something', function () {
    expect(!!documentGeneratorService).toBe(true);
  });

});
