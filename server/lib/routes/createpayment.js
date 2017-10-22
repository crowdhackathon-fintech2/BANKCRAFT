var db = require('../../util/db');
const bank = require('../controllers/bank')();

const simplify = require("../controllers/simplify")();

module.exports = function (req, res) {
    // Fetch all registered device tokens
    // Send to client
    bank.doTransaction(15.40);

    res.send({ status: true});
    // simplify.createSimplifyPayment(60);
};