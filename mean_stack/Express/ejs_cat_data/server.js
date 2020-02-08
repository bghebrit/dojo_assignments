const express = require("express");
const app = express();
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.use(express.static(__dirname + "/static"));
app.listen(8000, () => console.log("listening on port 8000"));

app.get("/cats", (req, res) => {
   res.render('cats');
})

app.get("/cats/chuttie", (req, res) => {
    var pops = [
        {name:"chuttie" , favourite_food:"Macaroni" , age:"5"},
    ];
   res.render('details',{cats: pops});
})

app.get("/cats/loopy", (req, res) => {
    var pops = [
        {name:"loopy" , favourite_food:"cheese steak" , age:"7"},
    ];
   res.render('details',{cats: pops});
})

 app.get("/cats/kookie", (req, res) => {
    var pops = [
        {name:"kookie" , favourite_food:"enjerito" , age:"6"},
    ];
   res.render('details',{cats: pops});
})

app.post('/users', (req, res) => {
    console.log(req.body) 
    res.redirect('/cats')
});

