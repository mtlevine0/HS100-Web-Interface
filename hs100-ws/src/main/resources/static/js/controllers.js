'use strict';

/* Controllers */

var weatherm8Controllers = angular.module('weatherm8Controllers',[]);

weatherm8Controllers.controller('IndexCtrl', function($scope) {
    $scope.message = 'Index';
});

weatherm8Controllers.controller('AboutCtrl', function($scope) {
    $scope.message = 'About';
});

weatherm8Controllers.controller('TempsCtrl', function($scope, $http) {
    $scope.message = "Temps"
});

weatherm8Controllers.controller('DevicesCtrl', function($scope) {
    $scope.message = 'Devices';
});