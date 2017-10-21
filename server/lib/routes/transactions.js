const db = require('../../util/db')();

module.exports = function (req, res) {
    res.setHeader('Content-Type', 'application/json');
    res.send(db.getDatabase());
};