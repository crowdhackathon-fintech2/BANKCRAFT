const api = require('./lib/api');
const bank = require('./lib/controllers/bank')();
const schedule = require('node-schedule');
const push = require('./lib/push')();
// Initialize API
api.initialize();
// uphold.tade();

bank.generateHistory();

push.pushNotification();

const event = schedule.scheduleJob("*/1 * * * *", function() {
    console.log('This runs every 1 minute');
    bank.doTransaction();
});
