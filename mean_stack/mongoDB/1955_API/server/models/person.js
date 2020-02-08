const mongoose = require('mongoose');

const PersonSchema = new mongoose.Schema({
    name: { type: String, required: true},
}, {timestamps: true});

const pers = mongoose.model('Person', PersonSchema);