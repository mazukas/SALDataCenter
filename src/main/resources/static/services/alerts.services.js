(function() {
	'use strict';

	angular.module('app').factory('alertsServices', alertsServices);

	function alertsServices($http) {

		return {
			get : function() {
				return $http({
				    method : "GET",
				    url : "/api/alerts",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
		}
	}
})();