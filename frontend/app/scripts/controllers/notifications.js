(function () {
    'use strict';

    angular.module('fpymeFrontApp')
        .controller('NotificationsCtrl', function ($scope, $rootScope, notificationsService, windowNotifications) {
            var socket,
                request,
                subSocket,
                calcType;

            calcType = function (type) {
                var result;
                if (type === 'INFO') {
                    result = 'info';
                } else if (type === 'WARNING') {
                    result = 'warning';
                } else if (type === 'DEBUG') {
                    result = 'success';
                } else {
                    result = "error";
                }
                return result;
            };

            $scope.notifications = [];
            $scope.permissions = $rootScope.permissions;
            $scope.configParams = $rootScope.configParams;
            $scope.show = true;
            $scope.$on("event:notification", function () {
                _(notificationsService.getNotifications()).forEach(function (notification) {
                    var obj;
                    if (notification.type === 'async') {
                        obj = {
                            async: true,
                            title: notification.title,
                            message: notification.message,
                            type: calcType(notification.severity.name)
                        };
                    } else {
                        obj = {
                            async: false,
                            msg: notification.message,
                            errorKey: notification.errorKey,
                            businessId: notification.businessId,
                            description: notification.description,
                            type: calcType(notification.severity && notification.severity.name)
                        };
                    }
                    $scope.notifications.push(obj);
                    _.delay(function () {
                      $scope.notifications = _.filter($scope.notifications, function (el) {
                        return obj != el;
                      });
                      $scope.$digest();
                    }, 30 * 1000);
                });
                window.scrollTo(0, 0);
                notificationsService.clear();
            });
            $scope.closeNotification = function (index) {
                $scope.notifications.splice(index, 1);
            };
            $scope.hasPermission = function () {
                return windowNotifications.hasPermission();
            };
            $scope.requestNotificationPermission = function () {
                windowNotifications.requestPermission();
            };
        });
}());
