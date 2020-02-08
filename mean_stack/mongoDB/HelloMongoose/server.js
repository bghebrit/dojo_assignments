const express = require("express");
const app = express();

const mongoose = require('mongoose');
const session = require('express-session');
app.use(session({
    secret: 'keyboardkitteh',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
  }))

mongoose.connect('mongodb://localhost/Users_db', {useNewUrlParser: true});

const UserSchema = new mongoose.Schema({
    name: String,
    age: Number
   })
   // create an object that contains methods for mongoose to interface with MongoDB
const User = mongoose.model('User', UserSchema);

app.listen(8000, () => console.log("listening on port 8000"));

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.use(express.static(__dirname + "/static"));
app.use(express.urlencoded({extended: true}));

app.post('/users', (req, res) => {
      const user = new User();
      user.name = req.body.name;
      user.age = req.body.age;
      user.save()
        .then(newUserData => console.log('user created: ', newUserData))
        .catch(err => console.log(err));
       
      res.redirect('/');
})

app.post('/users', (req, res) => {
  const user = new User(req.body);
  user.save()
      .then(() => res.redirect('/users'))
      .catch(err => {
          console.log("There is an error!", error);
          for (var key in error.errors) {
              req.flash('user', error.errors[key].message);
          }
          res.redirect('/');
      });
});

app.get('/users', (req, res) => {  
      Quote.find().sort('-createdAt')
          .then(data => res.render("index", {users: data}))
          .catch(err => res.json(err));
})
    

