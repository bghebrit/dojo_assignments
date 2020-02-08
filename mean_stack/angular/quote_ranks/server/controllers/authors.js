const mongoose = require('mongoose');
const authors = new mongoose.model('Author');
module.exports = {
    index: (req,res)=>{
        authors.find({})
            .then((data)=>{
                res.json(data);
            })
            .catch((err)=>{
                res.json(err)
            })
        },
    search: (req,res)=>{
        authors.findById(req.params.id)
            .then((data)=>{
                res.json(data);
            })
            .catch((err)=>{
                res.json(err)
            })
        },
    check: (req,res)=>{
        console.log(req.body)
        authors.findOne({name: req.body.name})
        .then(data=>{
            if(data.length > 1){
                data = {errors:{db:{message: "Already in the database"}} }
                res.json(data)
            }
            else{
                this.create
            }
        })
        .catch(data=>this.create)
    },
    create: (req,res)=>{
        authors.create(req.body)
            .then((data)=>{
                res.json(data);
            })
            .catch((err)=>{
                res.json(err)
            })
        },
    edit: (req,res)=>{
        authors.findByIdAndUpdate(req.params.id, {$push: {quotes: req.body}}, {runValidators: true})
            .then((data)=>{
                res.json(data);
            })
            .catch((err)=>{
                res.json(err)
            })
        },
    update: (req,res)=>{
        authors.findByIdAndUpdate(req.params.id, req.body, {runValidators: true})
            .then((data)=>{
                res.json(data);
            })
            .catch((err)=>{
                res.json(err)
            })
        },
    delete: (req,res)=>{
        authors.findByIdAndUpdate(req.params.id, {$pull: {quotes: req.body}}, {runValidators: true})
            .then((data)=>{
                res.json(data);
            })
            .catch((err)=>{
                res.json(err)
            })
        },
    upvote: (req, res)=>{
        authors.findById(req.params.id).then((data)=>{
            data.quotes[req.body.index].votes++
            data.save()
        })
        .then(data=>{
            res.json(data)
        })
        .catch(err=>{
            res.json(err)
        })
    },
    downVote: (req, res)=>{
        authors.findById(req.params.id).then((data)=>{
            data.quotes[req.body.index].votes--
            data.save()
        })
        .then(data=>{
            res.json(data)
        })
        .catch(err=>{
            res.json(err)
        })
    }
}