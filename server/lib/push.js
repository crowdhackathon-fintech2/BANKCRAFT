var db = require('../util/db');
var config = require('../config');
var gcm = require('node-gcm');

module.exports = function () {
    const GCM_API_KEY = "AAAAI9xJN6A:APA91bHO7wTQpjh7agJXmM6nlIR9enttX78X7FisGr-fwT1w7gOOPpxVu2PBblmaeur_21nlzuqFA0YiagO79gwpXwDduRfvxqTTgGHN6SMrRGuVcpxy-55CH1u9no6j5Yn4809w_plk";

    function pushNotification() {
        // Set up the sender with your GCM/FCM API key (declare this once for multiple messages)
        var sender = new gcm.Sender(GCM_API_KEY);

        // Prepare a message to be sent
        var message = new gcm.Message({
            data: {
                amount: '0.60'
            }
        });

        // Specify which registration IDs to deliver the message to
        var regTokens = ['dkHi6WxcOmI:APA91bE_NfwgglwzusmjUVwIkEPi28F0OO2NamYzSzNQ4qLrgpXpVmdxrY5C_J3xTxSVS6HTfr8vTsL8GC4p9D69xijgcLUmYwZC_zLkcPxoXOtU5kDjM36XzjcfHfNbl4gUkKVbQBC6'];

        // Actually send the message
        sender.send(message, {registrationTokens: regTokens}, function (err, response) {
            if (err) console.log(err);
            else console.log(response);
        });
    }

    return {
        pushNotification: pushNotification
    };
};