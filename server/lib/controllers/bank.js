const db = require('../../util/db')();
const request = require("request");
const moment = require("moment");
const WebSocket = require('ws');
const wss = new WebSocket.Server({ port: 8080 });
const push = require("../push")();

module.exports = function () {
    // Fetch all registered device tokens
    const DESCRS = ["Girlfriend gift", "Tickets", "Vasilopoulos", "High Heels"];
    const IBAN= "GR4501101030000010348012377";
    const USER_ID = "d3247c73-2073-4921-847d-b22a51090c45";
    const BANK_ID = "DB173089-A8FE-43F1-8947-F1B2A8699829";
    const ACCOUNT_ID = "762d1a5d-64bb-465f-a0d8-2dd87b95f169";
    const VIEW_ID = "owner";
    const SANDBOX_ID = "bankcraftNBG";
    const connected = [];
    let isOpened = false;

    wss.on('connection', function connection(ws) {
        connected.push(ws)
        db.getDatabase().transactions.forEach(a=> ws.send(JSON.stringify(a)))
        isOpened=true;
    });

    wss.on('disconnection', function connection(ws) {
        isOpened=false;
    });

    // console.log(getRandomDescription())

    function getRandomDescription(){
        return DESCRS[getRandomInt(0,DESCRS.length)];
    }

    function getRandomInt(min=0, max=90){
        return Math.floor(max - Math.random()*(max-min))
    }

    function doTransaction(amount){
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
                    value: { currency: 'EUR', amount: amount},
                    description: getRandomDescription()
                },
            json: true };

        request(options, function (error, response, body) {
            if (error) return console.error('Failed: %s', error.message);
            const obj = addTransactionToDatabase(body)
            push.pushNotification(0.60);
            //if(isOpened)
            connected.forEach(c => {
                try {
                    c.send(JSON.stringify(obj))
                } catch (e) {
                }
            })
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
        db.addTransaction(obj);
        return obj;
    }

    function generateHistory(){
        const numberOfTransactions = 2;
        for(let i=0; i<numberOfTransactions;i++){
            doTransaction();
        }
    }

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
        });

    }

    return {
        doTransaction:doTransaction,
        generateHistory:generateHistory
    }
};