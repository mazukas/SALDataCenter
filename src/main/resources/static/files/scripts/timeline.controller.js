(function () {
    'use strict';

    angular.module('app.files').controller('filesTimelineCtrl', [ '$scope', 'filesServices', 'filterFilter', '$rootScope', 'logger', '$filter', filesTimelineCtrl]);
        
    function filesTimelineCtrl($scope, filesServices, filterFilter, $rootScope, logger, $filter) {
        var init;

        $scope.files = [];

        init = function() {
        	var promise = filesServices.get();
    		promise.then(function(answer) {    			
    			$scope.files = answer.data;
    			var flip = true;
    			for (var i=0; i < $scope.files.length; i++) {
    				$scope.files[i].flip = flip;
    				flip = !flip;
    			}
    				

    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
        	
        };

        init();
    }
})(); 