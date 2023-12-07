const ProductController= require('../controllers/product_manager.controller')

 module.exports = (app) => {
    app.post("/api/products", ProductController.createProduct)
    app.get("/api/products", ProductController.getAllProduct)
    app.get("/api/products/:id", ProductController.getProduct)

}