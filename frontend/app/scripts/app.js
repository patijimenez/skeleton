	/*global angular: false, console: false, _: false */
(function () {
    'use strict';
//                                                                                         var app = angular.module("app", ["checklist-model"]);
    $.ajaxSetup({ cache: false });

    angular.module('fpymeFrontApp', ['ui.bootstrap', 'ui.date', 'ui.select2', 'ngUpload', 'ngSanitize', 'ui.codemirror', 'ui.tinymce', 'ngHtmlCompile', 'checklist-model'])
        .config(function ($routeProvider, $httpProvider) {
            $httpProvider.responseInterceptors.push('errorHttpInterceptor');
            $routeProvider
                .when('/', {
                    templateUrl: 'views/main.html',
                    controller: 'MainCtrl'
                })
                .when('/register', {
                    templateUrl: 'views/register.html',
                    controller: 'RegisterCtrl'
                })
                .when('/errors', {
                    templateUrl: 'views/errors.html',
                    controller: 'ErrorsCtrl'
                })
                .when('/welcome', {
                    templateUrl: 'views/welcome.html',
                    controller: 'WelcomeCtrl'
                })
                .when('/recover', {
                    templateUrl: 'views/recover.html',
                    controller: 'RecoverCtrl'
                })
                .when('/error/:errorId', {
                    templateUrl: 'views/error.html',
                    controller: 'ErrorCtrl'
                })
                .when('/recoverPassword/:tokenId', {
                  templateUrl: 'views/recoverPassword.html',
                  controller: 'RecoverPasswordCtrl'
                })
                .when('/tokenConfirm/:tokenId', {
                  templateUrl: 'views/tokenConfirm.html',
                  controller: 'TokenConfirmCtrl'
                })
                .when('/dashboard', {
                  templateUrl: 'views/dashboard.html',
                  controller: 'DashboardCtrl'
                })
                .when('/changePassword', {
                  templateUrl: 'views/changePassword.html',
                  controller: 'ChangePasswordCtrl'
                })
                .when('/developer', {
                  templateUrl: 'views/developer.html',
                  controller: 'DeveloperCtrl'
                })
                .when('/db', {
                  templateUrl: 'views/db.html',
                  controller: 'DbCtrl'
                })
                .when('/e/:errorId', {
                  templateUrl: 'views/e.html',
                  controller: 'ECtrl'
                })
                .when('/scripting', {
                  templateUrl: 'views/scripting.html',
                  controller: 'ScriptingCtrl'
                })
                .when('/runScripts', {
                  templateUrl: 'views/runScripts.html',
                  controller: 'RunScriptsCtrl'
                })
                .when('/administraReportes', {
                  templateUrl: 'views/administraReportes.html',
                  controller: 'AdministraReportesCtrl'
                })
                .when('/message', {
                  templateUrl: 'views/message.html',
                  controller: 'MessageCtrl'
                })
                .when('/administrarNotificaciones', {
                  templateUrl: 'views/administrarNotificaciones.html',
                  controller: 'AdministrarNotificacionesCtrl'
                })
                .when('/su', {
                  templateUrl: 'views/su.html',
                  controller: 'SuCtrl'
                })
                .when('/news', {
                  templateUrl: 'views/news.html',
                  controller: 'NewsCtrl'
                })
                .when('/batchProcessBoard', {
                  templateUrl: 'views/batchProcessBoard.html',
                  controller: 'BatchProcessBoardCtrl'
                })
                .when('/batchProcessEvents/:processId', {
                  templateUrl: 'views/batchProcessEvents.html',
                  controller: 'BatchProcessEventsCtrl'
                })
                .when('/batchProcessLog/:processEventId', {
                  templateUrl: 'views/batchProcessLog.html',
                  controller: 'BatchProcessLogCtrl'
                })
                .when('/batchProcessEventConsole/:processEventId', {
                  templateUrl: 'views/batchProcessEventConsole.html',
                  controller: 'BatchProcessEventConsoleCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                });
            }).run(function ($location, loggedService, urlService, $rootScope, configService, $log, messageService) {
            var unloggedUrls = urlService.getUnloggedUrls(),
                path = $location.path(),
                controller,
                parts,
                reg;


            $rootScope.configParams = {};
            $rootScope.permissions = {};

            reg = /(\/.*)\/.*/;
            parts = reg.exec(path);

            if(parts) {
                path = parts[1];
            }

            loggedService.hasPermission('error:show').then(function (data) {
              $rootScope.permissions.errorDetail = data.allowed;
            });

            configService.listConfigParams(['errors.show']).then(function (params) {
              $rootScope.configParams.showErrors = params['errors.show'];
            });

            if (!_.contains(unloggedUrls, path) || path === '/' || path === '') {
                        //TODO: redirect according to profile
            	$location.path('/dashboard');
            }


        });

}());
