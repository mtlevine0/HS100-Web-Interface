'use strict';


var weatherm8App = angular.module('weatherm8App', ['ngRoute', 'weatherm8Controllers', 'weatherm8Directives']);

weatherm8App.config(function($routeProvider, $locationProvider) {

    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });

    $routeProvider.
    when('/', {
        templateUrl: '/partials/_index.html',
        controller: 'IndexCtrl'
    }).
    when('/about', {
        templateUrl: 'partials/_about.html',
        controller: 'AboutCtrl'
    }).
    when('/temps', {
        templateUrl: '/partials/_temps.html',
        controller: 'TempsCtrl'
    }).
    when('/devices', {
        templateUrl: '/partials/_devices.html',
        controller: 'DevicesCtrl'
    }).
    otherwise({
        redirectTo: "/"
    });
});