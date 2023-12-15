class Ninja{
    constructor(name, health){
        this.name = name;
        this.health = health;
        this.speed = 3; 
        this.strength = 3; 
    }
    sayName(){
        console.log(this.name);
        return this
    }
    showStats(){
        console.log(`${this.name} : ${this.health} HP  ${this.speed} speed & ${this.strength} strength `)
        return this
    }

    drinkSake(){
        this.health += 10
        return this
    }
}
const ninja1 = new Ninja("Hyabusa", 100);
ninja1.sayName();
ninja1.showStats();

module.exports  = Ninja;

    