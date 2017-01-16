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
			},
			getTodayEventCountsChartPie : function() {
				return $http({
				    method : "GET",
				    url : "/api/events/today/chart/pie",
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getAllEventCountPie : function(fromDate, toDate) {
				return $http({
				    method : "GET",
				    url : "/api/events/all/chart/pie?from=" + fromDate + "&to=" + toDate,
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getEventsChartPie : function(dataSource, env, fromDate, toDate) {
				return $http({
				    method : "GET",
				    url : "/api/events/chart/pie/"+dataSource+"/"+env + "?from=" + fromDate + "&to=" + toDate,
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getEventsChartZoom : function(dataSource, env, fromDate, toDate) {
				return $http({
				    method : "GET",
				    url : "/api/events/chart/zoom/"+dataSource+"/"+env + "?from=" + fromDate + "&to=" + toDate,
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getEnvChartPie : function(fromDate, toDate) {
				return $http({
				    method : "GET",
				    url : "/api/events/chart/pie?from=" + fromDate + "&to=" + toDate,
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			},
			getEnvChartZoom : function(fromDate, toDate) {
				return $http({
				    method : "GET",
				    url : "/api/events/chart/zoom?from=" + fromDate + "&to=" + toDate,
				    headers : {
				        'Content-Type' : 'application/json'
				    }
				});
			}
		}
	}
})();