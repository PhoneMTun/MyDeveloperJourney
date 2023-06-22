const prompt = require("prompt-sync")();

let kidheight = prompt("What is your kid's height?");
let kidage = prompt("What is your kid's age?");

function rider(kidheight, kidage) {
    if (parseInt(kidheight) >= 42 && parseInt(kidage) >= 10) {
        console.log("Get on that ride, kiddo!");
    } else {
        console.log("Sorry kiddo. Maybe next year.");
    }
}

rider(kidheight, kidage);

