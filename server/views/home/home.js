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

    HomeCtrl.$inject = ["$websocket", "$http"];
    function HomeCtrl($websocket, $http) {
        const vm = this;
        const dataStream = $websocket('ws://localhost:8080');
        vm.trans = [];

        dataStream.onMessage(function (message) {
            console.log(message)
            //vm.collection.push(angular.fromJson(message.data).message);
            vm.trans.push(angular.fromJson(message.data));
        });

        vm.pay = function(){
            $http.get("/dopay") //no Time for POST and error handling!
        };

        vm.getTotalSaved = function(){
            return vm.trans.reduce((a,c)=> a+c.investedAmount,0)
        };

        vm.getTotalPurchases = function(){

        }
    }

})();