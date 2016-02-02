'use strict';

angular.module('fpymeFrontApp')
  .directive('documentListViewer', function (evaluationService, documentService,applicationService, $routeParams, $log) {
    return {
      templateUrl: 'views/documentListViewerTemplate.html',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
        scope.$watch(attrs.documents, function () {
          scope.documents = scope.$eval(attrs.documents);
        });

        scope.$watch(attrs.light, function(){
          scope.light = scope.$eval(attrs.light);
        });
        
        scope.$watch(attrs.deleted, function(){
          scope.deleted = scope.$eval(attrs.deleted);
        });

        attrs.$observe('docBase', function () {
          scope.db = attrs.docBase;
        });

        scope.$watch('selectedTodos', function () {
          if(scope.selectedTodos) {
            scope.isDocsument = false;
            scope.isFile = false;
            scope.isImage = false;
            scope.selectedDocumentId = null;
            scope.selectedDeteled = false;
          }
        });

        scope.reviewDocument = function (){
          applicationService.getDocumentsByApplication($routeParams.applicationId).then(function(data){
            scope.reviewCallDocument = data.current;
          });
        };

        scope.$watch('selectedDocumentId', function() {
          var hexPath;
          if(scope.selectedDocumentId) {
            scope.selectedTodos = false;
            scope.selectedDoc = _.find(scope.documents, function(document) {
              return document.id == scope.selectedDocumentId;
            });
            var hexPath = scope.selectedDoc.hexPath;
            documentService.getDocumentData(hexPath).then(function (data) {
              scope.documentData = _.clone(data);
              scope.isDocument = _.contains(['application/pdf'], data.mimeType);
              scope.isImage = _.contains(['image/png', 'image/jpg', 'image/jpeg'], data.mimeType);
              scope.isFile = false;
              if(scope.isDocument) {
                scope.documentDocId = hexPath;
              }
              if(scope.isImage) {
                scope.imageDocId = hexPath;
              }
              if(!scope.isImage && !scope.isDocument) {
                scope.documentDocId = null;
                scope.isExcel = _.contains(['application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'], data.mimeType);
                scope.isWord = _.contains(['application/vnd.openxmlformats-officedocument.wordprocessingml.document'], data.mimeType);
                scope.isOther = !scope.isWord && !scope.isExcel;
                scope.isFile = true;
                scope.docId = hexPath;
              }
            });
          }
        });
      }
    };
  });
