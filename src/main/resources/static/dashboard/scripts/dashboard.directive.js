(function () {
    'use strict';

    angular.module('app.dashboard').directive('dashboardFocus', ['$timeout', dashboardFocus]);

    // cusor focus when dblclick to edit
    function dashboardFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.dashboardFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
