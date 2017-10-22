(function(){
    "use strict";

    // Declare app level module which depends on views, and components
    angular.module("winvest", [
        "ngRoute",
        "ngAnimate",
        'ngWebSocket',
        "home",
    ]).
    config(["$locationProvider", "$routeProvider", function($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix("!");
        $routeProvider.otherwise({redirectTo: "/home"});
    }]);

})();