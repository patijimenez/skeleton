'use strict';

describe('Service: legalReqDocs', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var legalReqDocs;
  beforeEach(inject(function (_legalReqDocs_) {
    legalReqDocs = _legalReqDocs_;
  }));

  it('should do something', function () {
    expect(!!legalReqDocs).toBe(true);
  });

});
