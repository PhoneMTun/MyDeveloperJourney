const Ninja = require('./Ninja');
class Sensei extends Ninja{
    constructor(name, health = 200, speed = 10, strength = 10, wisdom = 10){
        super(name, health, speed, strength);
        this.wisdom = wisdom;
    }
    speakWisdom(){
    
        this.drinkSake();
        console.log("what one progerammer can do in one month, two programmers can do in two months.");
    }
}
// console.log("\n  Creating Bob");
// const ninja1 = new Ninja("Bob", 10);
// ninja1.sayName();
// ninja1.showStats();
// ninja1.drinkSake();

console.log("\n  Creating Billy");
const ninja2 = new Ninja("Billy", 20, 5, 7);
ninja2.sayName();
ninja2.showStats();
ninja2.drinkSake();

console.log("\n  Creating Sensei Billy");
const sensei1 = new Sensei("Sensei Billy");
sensei1.showStats();
sensei1.speakWisdom();