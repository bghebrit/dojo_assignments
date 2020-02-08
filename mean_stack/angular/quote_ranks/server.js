const express = require('express');

const app = express();
// using json
app.use(bodyParser.json());
// serving static assets from the this place
app.use(express.static( __dirname + '/public/dist/public' ));
const bodyParser = require('body-parser');
const path = require('path');

//mongoose
var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/QuoteRanks_DB');
//routes
require('./server/models/Author.js')(app);
require('./server/config/routes.js')(app);
// catch all routes 
app.all("*", (req,res,next) => {
    res.sendFile(path.resolve("./public/dist/public/index.html"))
});
app.listen(8000);