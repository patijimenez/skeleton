(function () {
    'use strict';

    var RFC_REGEXP = /^[A-Z]{4}\d{6}[A-Z]{6}([A-Z0-9]{1})\d{1}$/;

    angular.module('fpymeFrontApp')
        .directive('curp', function () {
            return {
                require: 'ngModel',
                link: function postLink(scope, element, attrs, ctrl) {
                    ctrl.$parsers.unshift(function (viewValue) {
                        viewValue = viewValue.toUpperCase();
                        if(RFC_REGEXP.test(viewValue)) {
                            ctrl.$setValidity('curp', true);
                        } else {
                            ctrl.$setValidity('curp', false);
                        }
                        element.val(viewValue);
                        return viewValue;
                    });
                }
            };
        });
}());
