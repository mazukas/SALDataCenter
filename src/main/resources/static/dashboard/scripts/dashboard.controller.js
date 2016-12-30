(function () {
    'use strict';

    angular.module('app.dashboard').controller('dashboardCtrl', [ '$scope', '$rootScope', 'eventsServices', 'dataSourcesServices', 'filesServices', dashboardCtrl]);
        
    function dashboardCtrl($scope, $rootScope, eventsServices, dataSourcesServices, filesServices) {
        $scope.todayEventCount = 0;
        $scope.todayFilesCount = 0;
        $scope.todayNewDataSources = 0;
    	var init = function() {
        	var promiseEvents = eventsServices.getTodayEventCount();
        	promiseEvents.then(function(answer) {
        		var total = 0;
        		for (var i=0; i < answer.data.length; i++) {
        			$scope.todayEventCount = $scope.todayEventCount + answer.data[i].eventCount;
        		}
    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
    		
        	var promiseNewDataSources = dataSourcesServices.getNewDataSources();
        	promiseNewDataSources.then(function(answer) {
    			$scope.todayNewDataSources = answer.data.length;
    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
        	
        	var promiseFiles = filesServices.getTodayFilesProcessed();
        	promiseFiles.then(function(answer) {
    			$scope.todayFilesCount = answer.data.length;
    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
    	};

    	init();
    }
})(); 


