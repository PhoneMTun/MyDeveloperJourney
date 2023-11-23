const JokeController = require('../controllers/jokes.controllers');

module.exports=(app)=> {
    app.get("/api/jokes", JokeController.getallJOkes),
    app.post("/api/jokes", JokeController.createNewJoke),
    app.get("/api/jokes/:_id", JokeController.getJokebyId)
    app.put("/api/jokes/:_id", JokeController.updateJoke),
    app.delete("/api/jokes/:_id", JokeController.deleteJoke)
};