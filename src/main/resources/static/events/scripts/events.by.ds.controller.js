(function() {
	'use strict';

	angular.module('app.events').controller('eventsByDataSourceCtrl',
			[ '$scope', 'eventsServices', 'dataSourcesServices', '$rootScope', eventsByDataSourceCtrl ]);

	function eventsByDataSourceCtrl($scope, eventsServices, dataSourcesServices, $rootScope) {
		var init;
		$scope.allDataSourcesAndEnv = [];
		$scope.dataSourceSelected;
		$scope.envSelected;
		$scope.fromDate = null;
		$scope.toDate = null;
		
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
		
		$scope.options = {
				ds: [],
				env: []
		};
		
		$scope.myDataSourcePie = {};
		
		$scope.myDataSourceZoom = {};
		
		$scope.setEnvOptions = function() {
			$scope.options.env = [];
			for (var i=0; i < $scope.allDataSourcesAndEnv.length; i++) {
				if ($scope.allDataSourcesAndEnv[i].name == $scope.dataSourceSelected) {
					$scope.options.env.push($scope.allDataSourcesAndEnv[i].env);
				}
			}
		}
    	
		$scope.loadGraphs = function() {
	    	var promiseEvents = eventsServices.getEventsChartPie($scope.dataSourceSelected, $scope.envSelected, $scope.fromDate.getTime(), $scope.toDate.getTime());
	    	promiseEvents.then(function(answer) {
	    		$scope.myDataSourcePie = answer.data;
			}, function(error) {
				// report something
			}, function(progress) {
				// report progress
			});
	    	
	    	
	    	var promiseEvents = eventsServices.getEventsChartZoom($scope.dataSourceSelected, $scope.envSelected, $scope.fromDate.getTime(), $scope.toDate.getTime());
	    	promiseEvents.then(function(answer) {
	    		$scope.myDataSourceZoom = answer.data;
			}, function(error) {
				// report something
			}, function(progress) {
				// report progress
			});
		};


    	var promiseDS = dataSourcesServices.get();
    	promiseDS.then(function(answer) {
    		//$scope.allDataSources = answer.data;
    		$scope.allDataSourcesAndEnv = answer.data;
    		
    		//Create list of distinct names
    		for (var i=0; i < $scope.allDataSourcesAndEnv.length; i++) {
    			var n = $scope.allDataSourcesAndEnv[i].name;
    		    if ($scope.options.ds.indexOf(n) === -1) {
    		    	$scope.options.ds.push(n);
    		    }
    		}
    		
		}, function(error) {
			// report something
		}, function(progress) {
			// report progress
		});
	}
})();