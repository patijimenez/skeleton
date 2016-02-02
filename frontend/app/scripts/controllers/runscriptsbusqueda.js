'use strict';

angular.module('fpymeFrontApp')
  .controller('RunscriptsbusquedaCtrl', function ($scope,developerService,urlService) {
        $scope.baseUrl = urlService.getBasePath();
        $scope.processing = false;
        $scope.scriptselected = false;

        $scope.noOfPages = null;
        $scope.currentPage = 1;
        $scope.maxSize = 25;

        $scope.getRunScripts = function(){
            developerService.getRunScritps($scope.maxSize, $scope.currentPage, $scope.searchCriteria).then(function (data){
                $scope.runscripts = data.runscripts;
                var numPages = Math.floor(data.total/$scope.maxSize);
                $scope.noOfPages = data.total % $scope.maxSize == 0 ? numPages : numPages + 1;
                $scope.scriptselected = false;
            });
        }

        $scope.$watch('currentPage', function(){
            $scope.getRunScripts();
        });

        $scope.executeStoredScript = function (script) {
            var opts = {
                lines: 15, // The number of lines to draw
                length: 15, // The length of each line
                width: 4, // The line thickness
                radius: 15, // The radius of the inner circle
                corners: 1, // Corner roundness (0..1)
                rotate: 0, // The rotation offset
                direction: 1, // 1: clockwise, -1: counterclockwise
                color: '#000', // #rgb or #rrggbb
                speed: 1, // Rounds per second
                trail: 60, // Afterglow percentage
                shadow: false, // Whether to render a shadow
                hwaccel: false, // Whether to use hardware acceleration
                className: 'spinner', // The CSS class to assign to the spinner
                zIndex: 2e9, // The z-index (defaults to 2000000000)
                top: '-2', // Top position relative to parent in px
                left: 'auto' // Left position relative to parent in px
            };
            var target = document.getElementById('save-spinner');
            var spinner = new Spinner(opts).spin(target);
            $scope.processing = true;
            developerService.executeStoredScript(script).then(function (data) {
                $scope.result = data;
                spinner.stop();
                $scope.processing = false;
            }, function (){
                spinner.stop();
                $scope.processing = false;
            });
        };

        $scope.getScript = function(script){
            $scope.script = script;
            $scope.scriptselected = true;
        }

        $scope.save = function(){
            jQuery('#scriptForm').submit();
        };

        $scope.getRunScripts();

  });
