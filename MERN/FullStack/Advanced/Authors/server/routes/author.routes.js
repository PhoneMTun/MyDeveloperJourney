const AuthorController = require('../controllers/author.controller')
const dbName = "authors";

module.exports =(app)=>{
    app.post(`/api/${dbName}/new`, AuthorController.createAuthor);
    app.get(`/api/${dbName}`, AuthorController.getAllAuthor);
    app.get(`/api/${dbName}/:id`, AuthorController.getAuthor);
    app.patch(`/api/${dbName}/:id`, AuthorController.updateAuthor);
    app.delete(`/api/${dbName}/:id`, AuthorController.deleteAuthor);
}