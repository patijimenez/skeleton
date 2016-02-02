'use strict';

angular.module('fpymeFrontApp')
  .factory('windowNotifications', function () {
    // Public API here
		if(window && window.webkitNotifications) {
			return {
				requestPermission: function () {
					window.webkitNotifications.requestPermission();
				},
				hasPermission: function () {
					return window.webkitNotifications.checkPermission();
				},
				sendNotification: function (icon, title, body) {
					if(title && body) {
						var notification = window.webkitNotifications.createNotification(icon, title, body);
						notification.show();
					}
				}
			};
		} else {
			return {
				requestPermission: function () {
				},
				hasPermission: function () {
					return 2;
				},
				sendNotification: function (icon, title, body) {
				}
			};
		}
  });
