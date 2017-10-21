const api = require('./lib/api');
const bank = require('./lib/controllers/bank')();
const schedule = require('node-schedule');
// Initialize API
api.initialize();
// uphold.tade();

bank.generateHistory();

const event = schedule.scheduleJob("*/1 * * * *", function() {
    console.log('This runs every 1 minute');
    bank.doTransaction();
});
