const db = require('../../util/db')();

module.exports = function (req, res) {
    console.log(req.body.token);
    if(req.body.token){
        db.getDatabase().token = req.body.token;
    }
    res.send({ status: true});
};