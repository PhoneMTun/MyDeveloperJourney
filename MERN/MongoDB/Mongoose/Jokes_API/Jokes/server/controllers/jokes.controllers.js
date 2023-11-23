const Joke = require('../models/jokes.model');

const getallJOkes =(req, res)=> {
    Joke.find()
    .then((allJokes)=>{
        res.json({ allJokes});
    })
    .catch((err)=>{
        res,json({ message:'Something went wrong', error:err });
    });
};

const getJokebyId=(req, res)=>{
    Joke.findOne({ _id:req.params._id})
        .then((joke)=>{
            res.json({ joke})
        })
        .catch((err)=>{
            res.json({message:'Something went wrong', error:err});
        });
}

const createNewJoke =(req,res)=>{
    Joke.create(req.body)
        .then((newjoke)=>{
            res.json({newjoke})
        })
        .catch((err)=>{
            res.json({message:'Something went wrong', error:err});
        });

}

const updateJoke =(req,res)=>{
    Joke.findOneAndUpdate({_id:req.params._id}, req.body, {
        new:true,
        runValidators:true,
    })
    .then((updateJoke)=>res.json(updateJoke))
    .catch((err)=>console.log(err));
} 

const deleteJoke = (req,res)=>{
    Joke.deleteOne({_id: req.params._id})
    .then((result)=>res.json(result))
    .catch((err)=>console.log(err));
}

module.exports ={
    getallJOkes,
    getJokebyId,
    createNewJoke,
    updateJoke,
    deleteJoke
}