const express= require("express");
const  cors=  require("cors");
const app= express();

app.use(express.json(), express.urlencoded({extended: true}));

app.use(
    cors({
        origin:"http://localhost:5173"
    }),

);

require("./config/mongoose.config");
require("./routes/product_manager.routes")(app);

app.listen(8000, ()=>{
    console.log("Listening on port 8000")
})