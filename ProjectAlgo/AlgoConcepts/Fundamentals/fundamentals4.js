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


// What Really Happened?
// Kyle (smarter than Kenny) notes that the chance of one disaster should be unrelated to the chance of another. Change whatHappensToday() function to create whatReallyHappensToday(). In this new function test for each disaster independently, instead of assuming exactly one disaster will happen. In other words, with this new function, all five might occur today – or none. Maybe Kenny will survive!

// function whatReallyHappensToday() {
//     let randEvents = [
//         Math.floor(Math.random() * 5) + 1,
//         Math.floor(Math.random() * 5) + 1,
//         Math.floor(Math.random() * 5) + 1,
//         Math.floor(Math.random() * 5) + 1,
//         Math.floor(Math.random() * 5) + 1
//     ];

//     let weather = {
//         'Volcano': 1,
//         'Tsunamis': 2,
//         'Earthquakes': 3,
//         'Blizzards': 4,
//         'Meteor': 5,
//     };


//     let eventsOccurred = [];

//     // Check which events have occurred
//     for (let event of Object.keys(weather)) {
//         if (randEvents.includes(weather[event])) {
//             eventsOccurred.push(event);
//         }
//     }

//     // Respond based on events
//     if (eventsOccurred.length === 0) {
//         return "Kyle is safe";
//     } else {
//         return "Today's events: " + eventsOccurred.join(", ");
//     }
// }

// console.log(whatReallyHappensToday());

// Soaring IQ
// Your time at the Dojo will definitely make you smarter! Let’s say a new Dojo student, Bogdan entered with a modest IQ of 101. Let’s say that during a 14-week bootcamp, his IQ rose by .01 on the first day, then went up by an additional .02 on the second day, then up by .03 more on the third day, etc. all the way until increasing by .98 on his 98th day (the end of 14 full weeks). What is Bogdan’s final IQ?

// function findingIQ(){
//     let initial = 101
//     return initial+0.98
// }
// console.log(findingIQ());

// Letter Grade
// Mr. Cerise teaches high school math. Write a function that assigns and prints a letter grade, given an integer representing a score from 0 to 100? Those getting 90+ get an ‘A’, 80-89 earn ‘B’, 70-79 is a ‘C’, 60-69 should get a ‘D’, and lower than 60 receive ‘F’. For example, given 88, you should log "Score: 88. Grade: B". Given the score 61, log the string "Score: 61. Grade: D".

// function letterGrade(){
//     let randGrate = Math.floor(Math.random() *(100)+1); 
//     if (randGrate>= 90){
//         return "Grade A"
//     }else if (randGrate>= 80){
//         return "Grade B"
//     }else if (randGrate>= 70){
//         return "Grade C"
//     }else if (randGrate>= 60 ) {
//         return "Grade D"
//     }else {
//         return "Fail!!"
//     }
// }
// console.log(letterGrade())

// More Accurate Grades
// For an additional challenge, add ‘-’ signs to scores in the bottom two percent of A, B, C and D scores, and “+” signs to the top two percent of B, C and D scores (sorry, Mr. Cerise never gives an A+). Given 88, console.log "Score: 88. Grade: B+". Given 61, log "Score: 61. Grade: D-" .

// let modifier = '';
// if (score < 100 && score >= 90) { // A grade has no A+
//     if (score === 90 || score === 91) modifier = '-';
// } else if (score % 10 <= 1) { // Bottom 2 percent of B, C, D
//     modifier = '-';
// } else if (score % 10 >= 8) { // Top 2 percent of B, C, D
//     modifier = '+';
// }

// return `Score: ${score}. Grade: ${grade}${modifier}`;


// // Examples
// console.log(assignGrade(88)); // Expected "Score: 88. Grade: B+"
// console.log(assignGrade(61)); // Expected "Score: 61. Grade: D-"