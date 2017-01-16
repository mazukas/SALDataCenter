(function() {
	'use strict';

	angular.module('app.search').controller('searchCtrl', [ '$scope', 'searchServices', '$rootScope', searchCtrl ]);

	function searchCtrl($scope, searchServices, $rootScope) {
		$scope.query = "";
		
		$scope.cmOption = {
			mode: 'text/x-hive',
			lineNumbers: true,
		    indentWithTabs: true,
		    matchBrackets: true,
		    extraKeys: {"Ctrl-Space": "autocomplete"},
		    hintOptions: {
		    	tables: {
		    		ACCOUNTS: {name: null, score: null, birthDate: null},
		    		ITEMS: {name: null, population: null, size: null},
		    		MESSAGES: {name: null, population: null, size: null},
		    		PERMISSIONS: {name: null, population: null, size: null},
		    		PING: {name: null, population: null, size: null},
		    		SEARCHES: {name: null, population: null, size: null},
		    		SESSIONS: {name: null, population: null, size: null},
		    		WEB: {name: null, population: null, size: null},
		    	}
		    }
		};
	}
})();