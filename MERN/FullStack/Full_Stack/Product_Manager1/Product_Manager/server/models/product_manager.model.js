const moongoose = require('mongoose');
const ProductSchema = new moongoose.Schema({
    title: {type:String},
    price: {type:Number},
    description: {type: String}
},{timestamps:true});

module.exports = moongoose.model('Product', ProductSchema)