var db = require('../../util/db');

module.exports = function (req, res) {
// console.log(req)
    const content = req.body;
    const title = req.query.title;
    res.setHeader('Content-Type', 'application/json');
    res.send({status:true})
};