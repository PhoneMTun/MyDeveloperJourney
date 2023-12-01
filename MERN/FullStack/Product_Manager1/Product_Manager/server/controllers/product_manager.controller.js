const Product= require('../models/product_manager.model')

module.exports= {

    createProduct:(req, res)=>{
        Product.create(req.body)
        .then((newProduct)=>res.json(newProduct))
        .catch((err)=>console.log(err))
    }
}