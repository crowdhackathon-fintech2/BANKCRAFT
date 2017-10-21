var express = require('express');
var config = require('../config');
var path = require('path');

exports.initialize = function () {
    // Initialize API
    var api = express();

    // Setup API routes
    setupRoutes(api);

    // Either use the runtime port or fallback to config
    var port = process.env.PORT || config.api.port;

    // Start listening to API requests from clients
    api.listen(port, function () {
        console.log('[API]', 'Listening on port ' +  port);
    });
};

function setupRoutes(api) {
    // Index endpoint
    // api.get('/', require('./routes/index'));
    api.use("/", express.static(path.join(__dirname + '/../views/')));
    api.get('/', function(req, res) {
        res.sendFile(path.join(__dirname + '/../views/index.html'));
    });
    // Send notifications endpoint
   api.get('/transactions/:id', require('./routes/transactions'));
    api.get('/transactions', require('./routes/transactions'));

    // Device registration endpoint
    //api.get('/register/:device', require('./routes/register'));
}