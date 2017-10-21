var api = require('./lib/api');
var bank = require('./lib/controllers/bank')();

// Initialize API
api.initialize();
// uphold.tade();

bank.generateHistory();

