(function() {
	'use strict';

	angular.module('app').factory('eventsServices', eventsServices);

	function eventsServices($http) {

		return {
			getTodayEventCount : function() {
				return $http({
				    method : "GET",
				    url : "/api/events/today",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
		}
	}
})();