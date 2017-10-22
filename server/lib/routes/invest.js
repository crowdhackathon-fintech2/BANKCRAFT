var db = require('../../util/db');
const simplify = require("../controllers/simplify")();

module.exports = function (req, res) {
// console.log(req)/
    simplify.createSimplifyPayment(60);
    res.setHeader('Content-Type', 'application/json');
    res.send({status:true})
};