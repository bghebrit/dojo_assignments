const express = require("express");
const app = express();
app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.use(express.static(__dirname + "/static"));
app.listen(8000, () => console.log("listening on port 8000"));

app.get("/cars", (req, res) => {
   res.render('cars');
})

app.get("/cats", (req, res) => {
   res.render('cats');
})

app.get("/cars/new", (req, res) => {
   res.render('new');
})


