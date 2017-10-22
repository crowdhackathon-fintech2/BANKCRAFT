const db = require('../../util/db')();

module.exports = function (req, res) {
    console.log(req.body.token);
    db.setToken(req.body.token)
    res.send({ status: true});
};