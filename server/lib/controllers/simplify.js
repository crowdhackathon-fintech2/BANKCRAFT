const db = require('../../util/db');
const Simplify = require("simplify-commerce");

module.exports = function () {
    const PUBLIC_KEY = "sbpb_ZTQ2NWM1OTAtMmVkOS00MGJkLWE5YjEtYTY3MjNiNzIyOTk0";
    const client = Simplify.getClient({
        publicKey: PUBLIC_KEY,
        privateKey: 'qZrhKccfr1hpx9ZgqfDZYo0iQ5gr8/5poa4vCuTVL155YFFQL0ODSXAOkNtXTToq'
    });

    function createSimplifyPayment(amount){
        console.log("Creating Simplify Payment: ");
        client.payment.create({
            amount : amount,
            customer : "dLpGKXxX4",
            description : "Payment #" + Math.floor((Math.random() * 100) + 1),
            reference : "7a6ef6be31",
            currency : "EUR"
        }, function(errData, data){

            if(errData){
                console.error("Error Message: " + errData.data.error.message);
                // handle the error
                return;
            }

            console.log("Payment Simplify Status: " + data.paymentStatus);
        });
    }

    return {
        createSimplifyPayment:createSimplifyPayment
    }

    /*client.customer.create({
        token : "5b47f93f-e4dc-47cb-b715-16529db93197",
        email : "apovtx@mastercard.com",
        name : "The one and only",
        reference : "Ref1"
    }, function(errData, data){

        if(errData){
            console.error("Error Message: " + errData.data.error.message);
            // handle the error
            return;
        }

        console.log("Success Response: " + JSON.stringify(data));
    });
*/
    /* client.payment.create({
         amount : "1000",
         token : "f15819fc-9821-40b8-8c3a-59b01494fcb9",
         description : "payment description",
         currency : "EUR"
     }, function(errData, data){
         if(errData){
             console.error("Error Message: " + errData.data.error.message);
             console.error(errData.data.error);
             // handle the error
             return;
         }
         console.log("Payment Status: " + data.paymentStatus);
     });*/
};

