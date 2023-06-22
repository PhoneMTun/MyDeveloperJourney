function greeting(name,day,enemy) {
    console.log(`Good day, ${name}!,its ${day} AM now!`);
    if (enemy == "Count Dooku") {
        console.log("i'm coming for you, Dooku!");
        return;
    }

}
greeting("John",9,"Count Dooku");