const AuthorController = require('../controllers/author.controller')

module.exports =(app)=>{
    app.post("/api/authors/new", AuthorController.createAuthor);
    app.get("/api/authors", AuthorController.getAllAuthor);
    app.get("/api/authors/:id", AuthorController.getAuthor);
    app.patch("/api/authors/:id", AuthorController.updateAuthor);
    app.delete("/api/authors/:id", AuthorController.deleteAuthor);
}