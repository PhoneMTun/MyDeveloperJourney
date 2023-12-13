const express = require ('express');
const Author = require('../models/author.models')

module.exports = {
    createAuthor:(req, res)=>{
        Author.create(req.body)
        .then((newAuthor)=>res.json(newAuthor))
        .catch((err) => {res.status(400).json({ err })})
    },
    getAllAuthor:(req, res)=>{
        Author.find({})
        .then((newAuthor)=>res.json(newAuthor))
        .catch((err) => {res.status(400).json({ err })})
    },
    getAuthor:(req, res)=>{
        Author.findOne({_id:req.params.id})
        .then((anAuthor)=>res.json(anAuthor))
        .catch((err) => {res.status(400).json({ err })})
    }, 
    updateAuthor:(req, res)=>{
        Author.findOneAndUpdate({_id:req.params.id}, req.body, {new:true, runValidators: true})
        .then((anAuthor)=>res.json(anAuthor))
        .catch((err) => {res.status(400).json({ err })})
    },
    deleteAuthor:(req, res)=>{
        Author.deleteOne({_id:req.params.id})
        .then(deleteConfimation=>res.json(deleteConfimation))
        .catch((err) => {res.status(400).json({ err })})
    }
}