'use strict';

var app = angular.module('fpymeFrontApp');


var FLOAT_REGEXP = /^\-?\d+((\.|\,)\d+)?$/;
app.directive('smartFloat', function() {
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function(viewValue) {
                if (FLOAT_REGEXP.test(viewValue)) {
                    var fvalue = parseFloat(viewValue.replace(',', '.'));
                    if(attrs.required && fvalue <= 0){
                      ctrl.$setValidity('float', false);
                    } else if(fvalue < 0) {
                      ctrl.$setValidity('float', false);
                    } else {
                      ctrl.$setValidity('float', true);
                    }
                    return fvalue;
                } else {
                    ctrl.$setValidity('float', false);
                    return undefined;
                }
            });
        }
    };
});
