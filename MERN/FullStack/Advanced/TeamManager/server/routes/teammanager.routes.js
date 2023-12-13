const TeamManagerController = require('../controllers/teammanager.controllers')
const dbName = "teammanager";

module.exports =(app)=>{
    app.post(`/api/${dbName}/new`, TeamManagerController.createPlayer);
    app.get(`/api/${dbName}`, TeamManagerController.getAllPlayer);
    app.get(`/api/${dbName}/:id`, TeamManagerController.getAPlayer);
    app.patch(`/api/${dbName}/:id`, TeamManagerController.updatePlayer);
    app.delete(`/api/${dbName}/:id`, TeamManagerController.deletePlayer);
}