(function () {
    'use strict';

    angular.module('app.alerts')
        .directive('alertsFocus', ['$timeout', alertsFocus]);

    // cusor focus when dblclick to edit
    function alertsFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.alertsFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
