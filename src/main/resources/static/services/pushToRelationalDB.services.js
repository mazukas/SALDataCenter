(function() {
	'use strict';

	angular.module('app').factory('pushToRelationalDBServices', pushToRelationalDBServices);

	function pushToRelationalDBServices($http) {

		return {
			oneTimePush : function(form) {
				return $http({
				    method : "POST",
				    url : "/api/pushToXXX/oneTime",
				    headers : {
				        'Content-Type' : 'application/json'
				    },
				    data: form
				});
			}
		}
	}
})();