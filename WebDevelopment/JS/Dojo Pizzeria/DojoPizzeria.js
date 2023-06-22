// function pizzaOven(crustType, sauceType, cheeses,toopings) {
//     var pizza={};
//     pizza.crustType = crustType;
//     pizza.sauceType = sauceType;
//     pizza.cheeses = cheeses;
//     pizza.toopings = toopings;
//     return pizza;
// }
// var pizza1=pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni","sausage"]);
// // console.log(pizza1);

// var pizza2=pizzaOven("hand tossed", "marinara", ["mozzarella","feta"], ["mushromm","olives","onions"]);
// // console.log(pizza2);

// var pizza3= pizzaOven("thin crust","Alfredo Sauce", "Goat Cheese", ["chicken","sausage", "olive", "onions", "pepperoni"]);
// // console.log(pizza3);

// var pizza4= pizzaOven("New york Style Crust", "pesto sauce",["provolone", "chedder"], ["ground beef","onions"]);
// // console.log(pizza4);



// function randomPizza(){
//     var choices=[pizza1,pizza2,pizza3,pizza4];
//     var random= choices[Math.floor(Math.random()*choices.length)];
//     console.log(random);
// }
// randomPizza();
 

var crusts=["deep dish","hand tossed", "thin crust","New york Style Crust"];
var sauce=["traditional", "marinara", "Alfredo sauce", "pesto sauce"];
var cheese=["mozzarella","feta", "Goat cheese", "provolone", "chedder"];
var toopings=["pepperoni", "sausage", "mushroom", "olives", "onions", "chicken", "ground beef"];



function randomRange(max, min){
    return Math.floor(Math.random() * (max-min))+min;
}
function randomChoice(arr){
    var i= Math.floor(Math.random()*arr.length);
    return arr[i];
}

function randomPizza(){
    var pizza={};
    pizza.crusts= randomChoice(crusts);
    pizza.sauce= randomChoice(sauce);
    pizza.cheese=[];
    pizza.toopings=[];
    for(var i=0; i<randomRange(5,1);i++){
        pizza.cheese.push(randomChoice(cheese));
    }
    for (var i=0; i<randomRange(5,1);i++){
        pizza.toopings.push(randomChoice(toopings));
    }
    return pizza;
}
console.log(randomPizza());