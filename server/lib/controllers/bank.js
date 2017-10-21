const db = require('../../util/db')();
const request = require("request");
const moment = require("moment");

module.exports = function () {
    // Fetch all registered device tokens
    const DESCRS = ["Girlfriend gift", "Tickets", "Vasilopoulos", "High Heels"];
    const IBAN= "GR4501101030000010348012377";
    const USER_ID = "d3247c73-2073-4921-847d-b22a51090c45";
    const BANK_ID = "DB173089-A8FE-43F1-8947-F1B2A8699829";
    const ACCOUNT_ID = "762d1a5d-64bb-465f-a0d8-2dd87b95f169";
    const VIEW_ID = "owner";
    const SANDBOX_ID = "bankcraftNBG";


    // console.log(getRandomDescription())

    function getRandomDescription(){
        return DESCRS[getRandomInt(0,DESCRS.length)];
    }

    function getRandomInt(min=0, max=90){
        return Math.floor(max - Math.random()*(max-min))
    }

    function doTransaction(){
        var options = { method: 'POST',
            url: `https://apis.nbg.gr/public/nbgapis/obp/v3.0.1/banks/${BANK_ID}/accounts/${ACCOUNT_ID}/${VIEW_ID}/transaction-request-types/sepa/transaction-requests`,
            headers:
                { provider: 'NBG',
                    provider_id: 'NBG.gr',
                    username: 'User1',
                    user_id: USER_ID,
                    application_id: SANDBOX_ID,
                    sandbox_id: SANDBOX_ID,
                    accept: 'text/json',
                    'content-type': 'text/json' },
            body:
                { to:
                    { iban: 'randomIban' },
                    charge_policy: 'SHARED',
                    value: { currency: 'EUR', amount: Math.random().toFixed(3)+getRandomInt(5,85)},
                    description: getRandomDescription()
                },
            json: true };

        request(options, function (error, response, body) {
            if (error) return console.error('Failed: %s', error.message);

            addTransactionToDatabase(body)

        });
    }

    function calculateInvest(amount){
        return Math.ceil(amount)-amount;
    }

    function addTransactionToDatabase(transactionResponse){

        const details = transactionResponse.details;
        if(!details){
            return;
        }
        const obj = {
            datetime:moment(details.start_date).format('DD/MM/YYYY'),
            description: details.description,
            amount: details.value.amount,
            investedAmount: calculateInvest(details.value.amount)
        };
        db.addTransaction(obj)

    }

    function generateHistory(){
        const numberOfTransactions = 2;
        for(let i=0; i<numberOfTransactions;i++){
            doTransaction();
        }
    }

    getTransactionHistory();
    function getTransactionHistory(){
        var options = { method: 'GET',
            url: `https://apis.nbg.gr/public/nbgapis/obp/v3.0.1/my/banks/${BANK_ID}/accounts/${ACCOUNT_ID}/transactions`,
            headers:
                { provider: 'NBG',
                    provider_id: 'NBG.gr',
                    username: 'User1',
                    user_id: USER_ID,
                    application_id: SANDBOX_ID,
                    sandbox_id: SANDBOX_ID,
                    accept: 'text/json',
                    'content-type': 'text/json'
                },
            json: true };

        request(options, function(error, response, body){
            if(error){
                return console.log('Error retrieving transactions');
            }

            body.forEach(v=>console.log(v.details.description))
        });

    }

    return {
        doTransaction:doTransaction,
        generateHistory:generateHistory
    }
};