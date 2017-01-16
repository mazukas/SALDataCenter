(function () {
    'use strict';

    angular.module('app.pushToRelationalDB').controller('pushToRelationalDBoneTimeCtrl', [ '$scope', 'pushToRelationalDBServices', 'dataSourcesServices', '$rootScope', pushToRelationalDBoneTimeCtrl]);
        
    function pushToRelationalDBoneTimeCtrl($scope, pushToRelationalDBServices, dataSourcesServices, $rootScope) {
		var init;
		$scope.form = {};
		
		
		$scope.allDataSourcesAndEnv = [];

		
		$scope.form.fromDate = {
			opened: false
		};
		$scope.form.toDate = {
				opened: false
		};
		
		$scope.fromDateOpen = function() {
			$scope.form.fromDate.opened = true;
		};
		$scope.toDateOpen = function() {
			$scope.form.toDate.opened = true;
		};
		
		$scope.options = {
				ds: [],
				env: []
		};
    	
		$scope.setEnvOptions = function() {
			$scope.options.env = [];
			for (var i=0; i < $scope.allDataSourcesAndEnv.length; i++) {
				if ($scope.allDataSourcesAndEnv[i].name == $scope.form.dataSource) {
					$scope.options.env.push($scope.allDataSourcesAndEnv[i].env);
				}
			}
		}
    	
    	var promiseDS = dataSourcesServices.get();
    	promiseDS.then(function(answer) {
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
    	
    	
    	$scope.stepOneBody = true;
    	$scope.stepTwoBody = false;
    	$scope.stepThreeBody = false;
    	$scope.nextStep = function(step) {
    		if (step == 1) {
    	    	$scope.stepOneBody = true;
    	    	$scope.stepTwoBody = false;
    	    	$scope.stepThreeBody = false;
    		} else if (step == 2) {
    	    	$scope.stepOneBody = false;
    	    	$scope.stepTwoBody = true;
    	    	$scope.stepThreeBody = false;
    		} else {
    	    	$scope.stepOneBody = false;
    	    	$scope.stepTwoBody = false;
    	    	$scope.stepThreeBody = true;
    		}
    	}
    	
    	$scope.execute = function() {
        	var promiseOneTimePush = pushToRelationalDBServices.oneTimePush($scope.form);
        	promiseOneTimePush.then(function(answer) {
        		
        		
    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
    	}
    }
})(); 