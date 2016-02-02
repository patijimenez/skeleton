'use strict';

describe('Service: windowNotifications', function () {

  // load the service's module
  beforeEach(module('fpymeFrontApp'));

  // instantiate service
  var windowNotifications;
  beforeEach(inject(function (_windowNotifications_) {
    windowNotifications = _windowNotifications_;
  }));

  it('should do something', function () {
    expect(!!windowNotifications).toBe(true);
  });

});
