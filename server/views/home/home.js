(function() {
    "use strict";

    angular.module("home", ["ngWebSocket"])
        .config(["$routeProvider", function ($routeProvider) {
            $routeProvider.when("/home", {
                templateUrl: "home/home.html",
                controller: "HomeCtrl",
                controllerAs: "vm"
            });
        }])
        .controller("HomeCtrl", HomeCtrl);

    HomeCtrl.$inject = ["$websocket"];
    function HomeCtrl($websocket) {
        const vm = this;
        const dataStream = $websocket('ws://localhost:8080');
        vm.trans = [];

        dataStream.onMessage(function (message) {
            //vm.collection.push(angular.fromJson(message.data).message);
            vm.trans.push(angular.fromJson(message.data));
            console.log(angular.fromJson(message.data))
        });
    }

})();