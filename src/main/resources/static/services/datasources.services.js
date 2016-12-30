(function() {
	'use strict';

	angular.module('app').factory('dataSourcesServices', dataSourcesServices);

	function dataSourcesServices($http) {

		return {
			get : function() {
				return $http({
				    method : "GET",
				    url : "/api/datasources",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getNewDataSources : function() {
				return $http({
				    method : "GET",
				    url : "/api/datasources/added/today",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
		}
	}
})();