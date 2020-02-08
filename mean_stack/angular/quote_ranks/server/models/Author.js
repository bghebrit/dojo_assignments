const mongoose = require('mongoose')
module.exports = ()=>{
    const AuthorSchema = new mongoose.Schema({
        name: {type: String, minlength: 3, required: true},
        quotes: [{
            quote: {type: String, minlength: 3},
            votes: {type: Number, default: 0},
        }]
    }, {timestamps: true})
    mongoose.model('Author', AuthorSchema)
} 