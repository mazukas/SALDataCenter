(function() {
	'use strict';

	angular.module('app').factory('searchServices', searchServices);

	function searchServices() {
		return {
			get : function(search) {
				return $http({
				    method : "post",
				    url : "/api/search",
				    headers : {
				        'Content-Type' : 'application/json'
				    },
				    data: search
				});
			}
		}
	}
})();