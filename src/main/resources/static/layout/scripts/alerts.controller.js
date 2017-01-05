(function () {
    'use strict';

    angular.module('app.alerts').controller('alertsCtrl', [ '$scope', 'alertsServices', '$rootScope', alertsCtrl]);
        
    function alertsCtrl($scope, alertsServices, $rootScope) {
        $scope.alerts = [];
    	
    	var promiseAlerts = alertsServices.get();
    	promiseAlerts.then(function(answer) {
    		$scope.alerts = answer.data;
		}, function(error) {
			// report something
		}, function(progress) {
			// report progress
		});
    }
})(); 