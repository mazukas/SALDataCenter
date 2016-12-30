(function () {
    'use strict';

    angular.module('app.datasources').controller('datasourcesCtrl', [ '$scope', 'dataSourcesServices', 'filterFilter', '$rootScope', 'logger', '$filter', datasourcesCtrl]);
        
    function datasourcesCtrl($scope, dataSourcesServices, filterFilter, $rootScope, logger, $filter) {
        var init;

        $scope.datasources = [];

        $scope.searchKeywords = '';

        $scope.filteredDatasources = [];

        $scope.row = '';

        $scope.select = function(page) {
            var end, start;
            start = (page - 1) * $scope.numPerPage;
            end = start + $scope.numPerPage;
            return $scope.currentPageDatasources = $scope.filteredDatasources.slice(start, end);
        };

        $scope.onFilterChange = function() {
            $scope.select(1);
            $scope.currentPage = 1;
            return $scope.row = '';
        };

        $scope.onNumPerPageChange = function() {
            $scope.select(1);
            return $scope.currentPage = 1;
        };

        $scope.onOrderChange = function() {
            $scope.select(1);
            return $scope.currentPage = 1;
        };

        $scope.search = function() {
            $scope.filteredDatasources = $filter('filter')($scope.datasources, $scope.searchKeywords);
            return $scope.onFilterChange();
        };

        $scope.order = function(rowName) {
            if ($scope.row === rowName) {
                return;
            }
            $scope.row = rowName;
            $scope.filteredDatasources = $filter('orderBy')($scope.datasources, rowName);
            return $scope.onOrderChange();
        };

        $scope.numPerPageOpt = [5, 10, 20, 25];

        $scope.numPerPage = $scope.numPerPageOpt[2];

        $scope.currentPage = 1;

        $scope.currentPageDatasources = [];

        init = function() {
        	var promise = dataSourcesServices.get();
    		promise.then(function(answer) {
    			$scope.datasources = answer.data;
    			$scope.search();
                $scope.select($scope.currentPage);
    		}, function(error) {
    			// report something
    		}, function(progress) {
    			// report progress
    		});
        	
        };

        init();
    }
})(); 