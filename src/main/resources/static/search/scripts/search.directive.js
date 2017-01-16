(function () {
    'use strict';

    angular.module('app.search')
        .directive('searchFocus', ['$timeout', searchFocus]);

    // cusor focus when dblclick to edit
    function searchFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.searchFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
