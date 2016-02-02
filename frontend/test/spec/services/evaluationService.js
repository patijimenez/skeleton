'use strict';

describe('Service: evaluationService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var evaluationService;
  beforeEach(inject(function (_evaluationService_) {
    evaluationService = _evaluationService_;
  }));

  it('should do something', function () {
    expect(!!evaluationService).toBe(true);
  });

});
