'use strict';

describe('Service: councilEvaluationService', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var councilEvaluationService;
  beforeEach(inject(function (_councilEvaluationService_) {
    councilEvaluationService = _councilEvaluationService_;
  }));

  it('should do something', function () {
    expect(!!councilEvaluationService).toBe(true);
  });

});
