var db = require('../util/db')();
var config = require('../config');
var gcm = require('node-gcm');

module.exports = function () {
    const GCM_API_KEY = "AAAAI9xJN6A:APA91bHO7wTQpjh7agJXmM6nlIR9enttX78X7FisGr-fwT1w7gOOPpxVu2PBblmaeur_21nlzuqFA0YiagO79gwpXwDduRfvxqTTgGHN6SMrRGuVcpxy-55CH1u9no6j5Yn4809w_plk";

    function pushNotification(amount) {
        if(!db.getDatabase().hasOwnProperty("token")){
            return;
        }
        const token = db.getDatabase().token;
        // Set up the sender with your GCM/FCM API key (declare this once for multiple messages)
        var sender = new gcm.Sender(GCM_API_KEY);

        // Prepare a message to be sent
        var message = new gcm.Message({
            data: {
                amount: amount
            }
        });

        // Specify which registration IDs to deliver the message to
        var regTokens = [token];

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