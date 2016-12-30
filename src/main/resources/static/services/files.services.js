(function() {
	'use strict';

	angular.module('app').factory('filesServices', filesServices);

	function filesServices($http) {

		return {
			get : function() {
				return $http({
				    method : "GET",
				    url : "/api/files",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getTodayFilesProcessed : function() {
				return $http({
				    method : "GET",
				    url : "/api/files/today",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
		
		
		}
	}
})();