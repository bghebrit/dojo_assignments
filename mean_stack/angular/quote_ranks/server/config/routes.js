const controller = require('../controllers/authors.js')
module.exports = (app)=>{
    app.get('/authors', controller.index)
    app.get('/authors/:id', controller.search)
    app.post('/authors', controller.check)
    app.put('/authors/:id', controller.update)
    app.put('/quotes/:id', controller.edit)
    app.delete('/quotes/:id', controller.delete)
    app.put('/quotes/:id/upvote', controller.upvote)
    app.put('/quotes/:id/downvote', controller.downVote)
}