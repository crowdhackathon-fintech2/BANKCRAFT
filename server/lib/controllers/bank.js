const db = require('../../util/db');
const request = require("request");


module.exports = function (req, res) {
     // Fetch all registered device tokens

    const BANK_ID = "DB173089-A8FE-43F1-8947-F1B2A8699829";
    const ACCOUNT_ID = "762d1a5d-64bb-465f-a0d8-2dd87b95f169";
    const VIEW_ID = "762d1a5d-64bb-465f-a0d8-2dd87b95f169";

    var options = { method: 'POST',
        url: `https://apis.nbg.gr/public/nbgapis/obp/v3.0.1/banks/${BANK_ID}/accounts/${ACCOUNT_ID}/${VIEW_ID}/transaction-request-types/sepa/transaction-requests`,
        headers:
            { provider: 'REPLACE_THIS_VALUE',
                provider_id: 'REPLACE_THIS_VALUE',
                username: 'REPLACE_THIS_VALUE',
                user_id: 'REPLACE_THIS_VALUE',
                application_id: 'REPLACE_THIS_VALUE',
                sandbox_id: 'REPLACE_THIS_VALUE',
                accept: 'text/json',
                'content-type': 'text/json' },
        body:
            { to: { iban: 'giviceha' },
                charge_policy: 'bofefr',
                value: { currency: 'LSL', amount: 92.03623212 },
                description: 'Odu no nijlaset uk lafarap bojci sone va mikec miwe elisa ad tar okamec tet fiffirhac.' },
        json: true };

    request(options, function (error, response, body) {
        if (error) return console.error('Failed: %s', error.message);

        console.log('Success: ', body);
    });};