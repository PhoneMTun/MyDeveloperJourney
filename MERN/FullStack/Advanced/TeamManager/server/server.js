const express = require('express');
const cors = require('cors')
const app = express();

app.use(express.json(), express.urlencoded({extended:true}));
app.use(cors({
        origin: "http://localhost:5173"
    })
)

require ("./config/teammanager.config")
require ("./routes/teammanager.routes")(app);
    app.listen(8000, () => {
        console.log('listening on port 8000')
    })