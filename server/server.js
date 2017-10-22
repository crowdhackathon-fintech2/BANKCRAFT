const api = require('./lib/api');
const schedule = require('node-schedule');
const push = require('./lib/push')();
const simplifyCtrl = require('./lib/controllers/simplify')();
// Initialize API
api.initialize();
// uphold.tade();

// bank.generateHistory();

/*


const event = schedule.scheduleJob("*!/1 * * * *", function() {
    console.log('This runs every 1 minute');
    bank.doTransaction();
});
*/
