(function () {
    'use strict';

    angular.module('app.files')
        .directive('filesFocus', ['$timeout', filesFocus]);

    // cusor focus when dblclick to edit
    function filesFocus($timeout) {
        var directive = {
            link: link
        };

        return directive;

        function link (scope, ele, attrs) {
            scope.$watch(attrs.filesFocus, function(newVal) {
                if (newVal) {
                    $timeout(function() {
                        return ele[0].focus();
                    }, 0, false);
                }
            });
        }
    }

})(); 
