  'use strict';

angular.module('fpymeFrontApp')
  .directive('documentViewer', function ($http) {
    return {
      templateUrl: 'views/documentViewerTemplate.html',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
        var reload;
        
        reload = function () {
            scope.docId = attrs.docId;

            if(scope.docId) {
                $http.get(attrs.docBase + '/getPdfData/' + scope.docId).success(function (data) {
                    scope.noOfPages = data.pages;
                    scope.outline = data.outline;
                    scope.author = data.author;
                });
            }
            scope.docBase = attrs.docBase;
            // attrs.$observe('docId', reload);
        };

        attrs.$observe('docId', reload);
        attrs.$observe('docBase', reload);
        attrs.$observe('downloadDocLabel', reload);

        scope.showOutline = attrs.showOutline && scope.$eval(attrs.showOutline);

        scope.zoom = 1.0;
        scope.rotate = 0;
        scope.page = 1;
        scope.imgFormat = 'png';
        scope.maxSize = 10;
        scope.downloadDocLabel = "Descargar documento";

        scope.zooms = [
          {'label': '50 %',  'value': 0.5},
          {'label': '75 %',  'value': 0.75},
          {'label': '100 %', 'value': 1.0},
          {'label': '125 %', 'value': 1.25},
          {'label': '150 %', 'value': 1.5},
          {'label': '175 %', 'value': 1.75},
          {'label': '200 %', 'value': 2.0}
        ];

        scope.rotates = [
          {'label': '0',  'value': 0},
          {'label': '90',  'value': 90},
          {'label': '180', 'value': 180},
          {'label': '270', 'value': 270}
        ];


        if(attrs.imgFormat) {
          scope.imgFormat = scope.imgFormat;
        }

        if(attrs.maxSize) {
          scope.maxSize = attrs.maxSize;
        }

        if(attrs.zoom) {
          scope.zoom = attrs.zoom;
        }

        if(attrs.rotate) {
          scope.rotate = attrs.rotate;
        }

        if(attrs.page) {
          scope.page = attrs.page;
        }
        if(attrs.downloadDocLabel){
          scope.downloadDocLabel = attrs.downloadDocLabel;
        }
        //scope.docId = attrs.docId;

        scope.openPage = function (pageNumber) {
            scope.page = pageNumber + 1;
        };

      }
    };
  });
