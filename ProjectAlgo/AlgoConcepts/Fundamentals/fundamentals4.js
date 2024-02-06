// Only Keep the Last Few
// Stan learned something today: that directly decrementing an array’s .length immediately shortens it by that amount. Given array arr and number X, remove all except the last X elements, and return arr (changed and shorter). Given ([2,4,6,8,10],3), change the given array to [6,8,10] and return it.

// arr= [2,4 ,6 ,8, 10];
// val = 3;

// function onlyKeepTheLastFew(arr,val){
//     for (let i= 0 ; i<arr.length; i++){
//         if (i == val+1 ){
//             arr.length = val
//             break
//         }
//         arr[i]= arr[arr.length-val+i]
//     }
//     return arr
    
// }
// console.log(onlyKeepTheLastFew(arr,val))


// Math Help
// Cartman doesn’t really like math; he needs help. You are given two numbers – coefficients M and B in the equation Y = MX + B. Build a function to return the X-intercept (his older cousin Fiaz wisely reminds him that X-intercept is the value of X where Y equals zero; Cartman just snorts in his general direction).

// function mathHelp (M,B){
//     M  == 0?  "Its a horizonal line" : -B/M
// }

// Poor Kenny
// Kenny tries to stay safe, but somehow everyday something happens. Out of the last 100 days, there were 10 days with volcanos, 15 others with tsunamis, 20 earthquakes, 25 blizzards and 30 meteors (for 100 days total). If these probabilities continue, write whatHappensToday() to print a day’s outcome.

// function whatHappensToday() {
//     let randDay = Math.floor(Math.random() * (100)+1);
//     if (randDay <= 10){
//         return "Volcano"
//     }else if (randDay<= 15){
//         return "Tsunamis"
//     }else if(randDay<+ 20){
//         return "Earthquakes"
//     }else if(randDay<= 25){
//         return "Blizzards"
//     }else if(randDay<= 30){
//         return "Meteor"
//     }
// }
// console.log(whatHappensToday());

