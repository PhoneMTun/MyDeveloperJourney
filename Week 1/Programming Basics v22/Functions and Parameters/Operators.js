function howMychLeftOverCake(numberOfPieces, numberOfPeople) {
    var remaining=numberOfPieces%numberOfPeople;
        if(remaining==0){
            console.log("No Leftovers for you!");
        }
        else if(remaining<=2){
            console.log("You have some leftovers");
        }
        else if(remaining<=5){
            console.log("You have leftovers to share");
        }
        else if(numberOfPieces>=5){
            console.log("Hold another party");
    }

}
howMychLeftOverCake(12, 5);
