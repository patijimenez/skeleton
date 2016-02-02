(function () {
  'use strict';

  var RFC_REGEXP = /^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$/;

  angular.module('fpymeFrontApp')
  .directive('rfc', function () {
    return {
      require: 'ngModel',
    link: function postLink(scope, element, attrs, ctrl) {
      ctrl.$parsers.unshift(function (viewValue) {
        viewValue = viewValue.toUpperCase();
        if(RFC_REGEXP.test(viewValue)) {
          ctrl.$setValidity('rfc', true);
        } else {
          ctrl.$setValidity('rfc', false);
        }
        element.val(viewValue);
        return viewValue;
      });
    }
    };
  });
}());
