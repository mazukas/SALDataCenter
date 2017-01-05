(function () {
    'use strict';

    angular.module('app.pushToRelationalDB')
        .directive('pushToRelationalDBFocus', ['$timeout', pushToRelationalDBFocus]);

    // cusor focus when dblclick to edit
    function pushToRelationalDBFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.pushToRelationalDBFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
