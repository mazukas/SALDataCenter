(function () {
    'use strict';

    angular.module('app.events')
        .directive('eventsFocus', ['$timeout', eventsFocus]);

    // cusor focus when dblclick to edit
    function eventsFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.eventsFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
