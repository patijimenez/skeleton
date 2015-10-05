(function () {
  'use strict';

  angular.module('fpymeFrontApp')
  .directive('numberMax', function ($log) {
    return {
      require: 'ngModel',
    link: function postLink(scope, element, attrs, ctrl) {
      ctrl.$parsers.unshift(function (viewValue) {
        var maxlength = parseInt(attrs.maxlength, 10) || 5;
        
        viewValue = viewValue.substr(0, maxlength);
        element.val(viewValue);
        
        return viewValue;
      });
    }
    };
  });
}());
