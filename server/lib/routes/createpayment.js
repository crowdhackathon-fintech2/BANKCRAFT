var db = require('../../util/db');
const bank = require('../controllers/bank')();
const push = require("../push")();

module.exports = function (req, res) {
    // Fetch all registered device tokens
    // Send to client
    bank.doTransaction(15.40);
    res.send({ status: true});
    push.pushNotification();
};