(function () {
    'use strict';

    angular.module('app.datasources')
        .directive('datasourcesFocus', ['$timeout', datasourcesFocus]);

    // cusor focus when dblclick to edit
    function datasourcesFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.datasourcesFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
