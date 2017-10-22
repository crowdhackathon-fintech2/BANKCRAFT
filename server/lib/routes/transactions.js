const db = require('../../util/db')();

module.exports = function (req, res) {
    const data = db.getDatabase();
    data.total = 17+data.transactions.reduce((a,c)=>a=a+c.investedAmount,0);
    if(res) {
        res.setHeader('Content-Type', 'application/json');
        res.send(data);
        return
    }
    return data;
};