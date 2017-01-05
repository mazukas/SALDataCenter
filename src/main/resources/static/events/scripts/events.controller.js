(function() {
	'use strict';

	angular.module('app.events').controller('eventsCtrl',
			[ '$scope', 'eventsServices', '$rootScope', eventsCtrl ]);

	function eventsCtrl($scope, eventsServices, $rootScope) {
		var init;
		
		$scope.dataSourceSelected = "mock-data-source-1";
		$scope.envSelected = "DEV";
		
		$scope.myDataSource = {
			    chart: {
			        caption: "All Events For " + $scope.dataSourceSelected + " (" + $scope.envSelected + ")",
			        startingangle: "120",
			        showlabels: "0",
			        showlegend: "1",
			        enablemultislicing: "0",
			        slicingdistance: "15",
			        showpercentvalues: "1",
			        showpercentintooltip: "0",
			        plottooltext: "Age group : $label Total visit : $datavalue",
			        theme: "zune"
			    },
			    data: []
			};
    	
    	var promiseAlerts = eventsServices.getAllEventsByDataSourceAndEnv($scope.dataSourceSelected, $scope.envSelected);
    	promiseAlerts.then(function(answer) {
    		$scope.myDataSource.data = answer.data;
		}, function(error) {
			// report something
		}, function(progress) {
			// report progress
		});


	}
})();