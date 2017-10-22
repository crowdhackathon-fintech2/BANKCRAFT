var db = require('../../util/db');
const bank = require('../controllers/bank')();

module.exports = function (req, res) {
    console.log(res)
    res.send({ status: true});
};