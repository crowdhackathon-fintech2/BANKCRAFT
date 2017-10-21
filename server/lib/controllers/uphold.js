var db = require('../../util/db');
var upholdSDK = require('@uphold/uphold-sdk-javascript');

module.exports = function () {


    const sdk = new SDK({
        clientId: 'foo',
        clientSecret: 'bar'
    });

    //do your thing
    return {
        test: function(){
            console.log('test');
            console.log(upholdSDK);
        },

    }
};