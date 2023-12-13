const mongoose = require('mongoose')
const dbname = "teamManager"

mongoose.connect(`mongodb://localhost/${dbname}`,{
    useNewUrlParser: true,
    useUnifiedTopology: true,
})
    .then(() =>console.log(`Connected to ${dbname}`))
    .catch(err => console.log(`Something went wrong connecting to ${dbname}`, err))