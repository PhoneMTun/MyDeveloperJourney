const TeamManager = require('../models/teammanager.models');

module.exports= {
    createPlayer:(req, res) =>{
        TeamManager.create(req.body)
            .then((newPlayer)=>res.json(newPlayer))
            .catch((err)=>{res.status(400).json(err)});
        },
    getAllPlayer:(req, res) =>{
        TeamManager.find({})
        .then((Players) => res.json(Players))
        .catch((err)=>{res.status(400).json(err)})
    }, 
    getAPlayer:(req, res) =>{
        TeamManager.findOne({_id:req.params.id})
        .then((anauthor)=>res.json(anauthor))
        .catch((err)=>{res.status(400).json(err)})
    },
    updatePlayer:(req, res) =>{
        TeamManager.findOneAndUpdate({_id:req.params.id}, req.body, {new:true, runValidators:true})
        .then((anAuthor)=>res.json(anAuthor))
        .catch((err)=>{res.status(400).json(err)})
    },
    deletePlayer:(req, res) =>{
        TeamManager.deleteOne({_id:req.params.id})
        .then(deleteConfirmation=>res.json(deleteConfirmation))
        .catch((err)=>{res.status(400).json(err)})
    }
        
    }