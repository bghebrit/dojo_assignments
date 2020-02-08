const express = require("express");
const app = express();
const session = require('express-session');
app.use(session({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
  }))

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.use(express.static(__dirname + "/static"));
app.use(express.urlencoded({extended: true}));
app.listen(8000, () => console.log("listening on port 8000"));

app.get('/', (req, res) => {
    console.log("Value of name in session: ", req.session.name);
    res.render('index');
})

app.post('/submit', (req, res) => {
    console.log(req.body)
    var context = { 
        name : req.body.name,
        location : req.body.location,
        language : req.body.language,
        comment : req.body.comment 
    }
    res.render('results', context);
})




