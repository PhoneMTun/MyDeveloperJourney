const ProductController= require('../controllers/product_manager.controller')

 module.exports = (app) => {
    app.post("/api/products", ProductController.createProduct)
    
 }