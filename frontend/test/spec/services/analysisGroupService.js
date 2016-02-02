'use strict';

describe('Service: Analysisgroupservice', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var Analysisgroupservice;
  beforeEach(inject(function (_Analysisgroupservice_) {
    Analysisgroupservice = _Analysisgroupservice_;
  }));

  it('should do something', function () {
    expect(!!Analysisgroupservice).toBe(true);
  });

});
