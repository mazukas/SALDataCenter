(function() {
	'use strict';

	angular.module('app').factory('pushToRelationalDBServices', pushToRelationalDBServices);

	function pushToRelationalDBServices($http) {

		return {
			/*
			get : function() {
				return $http({
				    method : "GET",
				    url : "/api/alerts",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
			*/
		}
	}
})();