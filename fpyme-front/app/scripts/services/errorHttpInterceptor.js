'use strict';

angular.module('fpymeFrontApp')
  .factory('errorHttpInterceptor', function ($q, notificationsService, $location, $rootScope, $log, urlService) {
		return function (promise) {
        var getRootException = function (ex) {
          var it = ex.cause;
          if(it) {
            while(it.cause) {
              it = it.cause;
            };
          } else {
            it = ex;
          }
          return it;
        };
        var eventExceptions = {
          "org.hibernate.StaleObjectStateException": "concurrentModification",
          "org.hibernate.exception.LockAcquisitionException": "concurrentModification",
          "org.springframework.dao.CannotAcquireLockException": "concurrentModification"
        };
        return promise.then(function (response) {
            return response;
        }, function (response) {
            var reg, parts, path;

            path = $location.path();

            reg = /(\/.*)\/.*/;
            parts = reg.exec(path);

            if(parts) {
                path = parts[1];
            }
						var unloggedUrls = urlService.getUnloggedUrls();
						if (response.status == 401) {
                if (!_.contains(unloggedUrls, path)) {
                    $rootScope.$broadcast('loginRequired');
                    location.href = urlService.getBasePath() + '/app/auth/login?targetUri=#' + encodeURI($location.path());
                }
						} else {
                var exception = getRootException(response.data);
								$log.log(response.data);
                if(eventExceptions[exception['class']]) {
                  $rootScope.$broadcast(eventExceptions[exception['class']], exception);
                } else {
                  notificationsService.addNotification(response.data);
                }
						}
            return $q.reject(response);
        });
    };
  });
