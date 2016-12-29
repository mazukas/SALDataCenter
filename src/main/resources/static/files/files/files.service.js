(function() {
	'use strict';

	angular.module('app.files').factory('filesStorage', filesStorage);

	function filesStorage($http) {

		return {
			get : function() {
				return $http({
				    method : "GET",
				    url : "/api/files",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
		}
	}
})();