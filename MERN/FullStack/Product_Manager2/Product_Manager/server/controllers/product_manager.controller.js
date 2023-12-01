const Product= require('../models/product_manager.model')

module.exports= {

    createProduct:(req, res)=>{
        Product.create(req.body)
        .then((newProduct)=>res.json(newProduct))
        .catch((err)=>console.log(err))
    },

    getAllProduct:(req, res)=>{
        Product.find({})
        .then((persons)=>{
            console.log(persons);
            res.json(persons);
        })
        .catch((err)=>
            {console.log(err)
            response.json(err)})
    },
    getProduct:(req, res)=>{
        Product.findOne({_id:req.params.id})
            .then(product=>res.json(product))
            .catch((err)=>console.log(err));
    }
}