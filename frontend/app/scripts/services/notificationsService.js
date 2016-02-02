(function () {
	'use strict';

	angular.module('fpymeFrontApp')
		.factory('notificationsService', function (windowNotifications, $rootScope) {
			var imageUrl = '/images/logos/fondo_pyme_logotype_alone.jpg';
			var notifications = [];
			// Public API here
			return {
				getNotifications: function() { return notifications },
			  addNotification: function (notification) {
					if(windowNotifications.hasPermission() === 0) {
						if(notification.type == 'async') {
							windowNotifications.sendNotification(imageUrl, notification.title, notification.message);
						} else {
							windowNotifications.sendNotification(imageUrl, notification.errorId, notification.description);
						}
					}
					notifications.push(notification);
					$rootScope.$broadcast("event:notification");
				},
				clear: function () {
					notifications = [];
				}
			};
		});
}());
