(function () {
    'use strict';

    angular.module('app.files').controller('filesCtrl', [ '$scope', 'filesStorage', 'filterFilter', '$rootScope', 'logger', '$filter', filesCtrl]);
        
    function filesCtrl($scope, filesStorage, filterFilter, $rootScope, logger, $filter) {
        var init;

        $scope.files = [];

        $scope.searchKeywords = '';

        $scope.filteredFiles = [];

        $scope.row = '';

        $scope.select = function(page) {
            var end, start;
            start = (page - 1) * $scope.numPerPage;
            end = start + $scope.numPerPage;
            return $scope.currentPageFiles = $scope.filteredFiles.slice(start, end);
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
            $scope.filteredFiles = $filter('filter')($scope.files, $scope.searchKeywords);
            return $scope.onFilterChange();
        };

        $scope.order = function(rowName) {
            if ($scope.row === rowName) {
                return;
            }
            $scope.row = rowName;
            $scope.filteredFiles = $filter('orderBy')($scope.files, rowName);
            return $scope.onOrderChange();
        };

        $scope.numPerPageOpt = [5, 10, 20, 25];

        $scope.numPerPage = $scope.numPerPageOpt[2];

        $scope.currentPage = 1;

        $scope.currentPageFiles = [];

        init = function() {
        	
        	var promise = filesStorage.get();
    		promise.then(function(answer) {
    			
    			$scope.files = answer.data;
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