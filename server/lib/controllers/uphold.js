var db = require('../../util/db');
var request = require('request-promise');

const apiURL = "https://api-sandbox.uphold.com/v0";

module.exports = function () {
    //do your thing
    return {
        init: function () {
            var self = this;
            self.getMe();
            self.getCards().then(function(response){
                let cards = JSON.parse(response);
                self.createTransaction({
                    cardId:cards[0].id,
                    amount:100,
                    currency:"EUR",
                    destination:"apovtx@gmail.com"
                }).then(function(response){
                    console.log(response);
                }).catch(function(error){
                    console.log('Something went wrong while creating transaction');
                });
            });
        },
        getAccessToken: function () {
            return "4f2905326a1e0f7aaa638833edd4c318f8ec9b6d";
        },
        getCards: function(){
            let options = {
                method: "GET",
                uri: apiURL + "/me/cards",
                headers: {
                    "Authorization": "Bearer " + this.getAccessToken()
                }
            };
            return request(options);
        },
        createTransaction: function (transactionData) {
            //destination can be Bitcoin address, account ID, application ID or Uphold Username
            let options = {
                method: "POST",
                uri: apiURL + "/me/cards/" + transactionData.cardId + "/transactions",
                headers: {
                    "Authorization": "Bearer " + this.getAccessToken(),
                    "Content-Type" : "application/json"
                },
                data: {
                    "denomination": {
                        "amount": transactionData.amount,
                        "currency": transactionData.currency
                    },
                    "destination": transactionData.destination
                }
            };
            return request(options);
        },
        getMe: function () {
            let options = {
                method: "GET",
                uri: apiURL + "/me",
                headers: {
                    "Authorization": "Bearer " + this.getAccessToken()
                }
            };
            request(options, function (error, response, body) {
                if (response.statusCode === 200) {
                    return body;
                } else {
                    return {error: 1, errorMessage: 'Something went wrong'}
                }
            });
        },
    }
};

