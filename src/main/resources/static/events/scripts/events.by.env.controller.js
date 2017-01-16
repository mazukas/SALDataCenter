(function() {
	'use strict';

	angular.module('app.events').controller('byEnvEventsCtrl', 
			[ '$scope', 'eventsServices', 'dataSourcesServices', '$rootScope', byEnvEventsCtrl ]);

	function byEnvEventsCtrl($scope, eventsServices, $rootScope) {
		$scope.envPie = {};
		$scope.envZoom = {};
		
		$scope.fromDate = {
			opened: false
		};
		$scope.toDate = {
			opened: false
		};
			
		$scope.fromDateOpen = function() {
			$scope.fromDate.opened = true;
		};
		$scope.toDateOpen = function() {
			$scope.toDate.opened = true;
		};
		
		$scope.loadGraphs = function() {
	    	var promiseEvents = eventsServices.getEnvChartPie($scope.fromDate.getTime(), $scope.toDate.getTime());
	    	promiseEvents.then(function(answer) {
	    		$scope.envPie = answer.data;
			}, function(error) {
				// report something
			}, function(progress) {
				// report progress
			});
	    	
	    	
	    	var promiseEvents = eventsServices.getEnvChartZoom($scope.fromDate.getTime(), $scope.toDate.getTime());
	    	promiseEvents.then(function(answer) {
	    		$scope.envZoom = answer.data;
			}, function(error) {
				// report something
			}, function(progress) {
				// report progress
			});
		};
		
	}
})();