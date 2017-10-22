// In-memory persistence for simplicity
const data = {
    transactions:[
        { datetime: '21/10/2017',
            description: 'Vasilopoulos',
            amount: 65.84,
            investedAmount: 0.16 },
        { datetime: '21/10/2017',
            description: 'Tickets',
            amount: 15.80,
            investedAmount: 0.30 },

    ]
};

/*

exports.write = function(item) {
    // Avoid duplicate items
    if (data.indexOf(item) === -1) {
        data.push(item);
    }
};

exports.read = function() {
    // Expose data externally
    return data;
};
*/

module.exports = function(){
    return {
        getDatabase:function(){
            return data;
        },
        addTransaction: function(obj){
            if(!data.hasOwnProperty("transactions")){
                data.transactions = [];
            }
            data.transactions.push(obj)
        }
    };
};