'use strict';

angular.module('fpymeFrontApp')
.filter('ellipsize', function () {
  return function (str, max_length, position, ellipsis) {

    var beg, end;

    // Default values
    position = position ? position : 0.5;
    max_length = max_length ? max_length : 20;
    ellipsis = ellipsis ? ellipsis : '…';

    if(!str) {
      return "";
    }

    // Is the string long enough to ellipsize?
    if (str.length <= max_length) {
      return str;
    }

    beg = str.substr(0, Math.floor(max_length * position));
    position = (position > 1) ? 1 : position;

    if (position === 1) {
      end = str.substr(0,  - (max_length - beg.length));
    } else {
      end = str.substr( - (max_length - beg.length));
    }

    return beg + ellipsis + end;

  };
});
