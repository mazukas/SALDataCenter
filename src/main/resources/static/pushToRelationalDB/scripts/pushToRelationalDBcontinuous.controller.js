(function () {
    'use strict';

    angular.module('app.pushToRelationalDB').controller('pushToRelationalDBCtrl', [ '$scope', 'pushToRelationalDBServices', 'dataSourcesServices', '$rootScope', pushToRelationalDBCtrl]);
        
    function pushToRelationalDBCtrl($scope, pushToRelationalDBServices, dataSourcesServices, $rootScope) {

    	$scope.oneTimePushDetails = {
    		dsAndEnv: null
    	};
    	
        $scope.allDatasources = [];
    	var init = function() {
        	var promiseEvents = dataSourcesServices.get();
        	promiseEvents.then(function(answer) {
        		$scope.allDatasources = answer.data;
    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
    	};

    	init();
    	
    }
})(); 