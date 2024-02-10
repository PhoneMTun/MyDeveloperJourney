// Threes and Fives
// Create threesFives() that adds values from 100 and 4000000 (inclusive) if that value is evenly divisible by 3 or 5 but not both. Display the final sum in the console.

// Second: Create betterThreesFives(start, end) that allows you to enter arbitrary start and end values for your range. Think of threesFives() as betterThreesFives(100,4000000).


// function threesFives(start, end) {
//     let sum = 0;
//     for (var i = start; i <= end; i++)
//     if (i % 3 == 0 && i % 5 == 0) {
//         continue;
//     }else if (i % 3 == 0 || i % 5 == 0){
//         sum += i
//     }   
//     console.log(sum)
// }
// threesFives( 100, 4000000)

// function betterThreesFives(start, end) {
//     let sum = 0;
//     for (let i = start; i <= end; i++) {
//         // Check if the number is a multiple of 3 or 5, but not both
//         if ((i % 3 === 0 || i % 5 === 0) && !(i % 3 === 0 && i % 5 === 0)) {
//             sum += i;
//         }
//     }
//     return sum;
// }

// console.log(betterThreesFives(100, 4000000));

// function GenerateCoinChange(amt) {
//     // Convert amount to cents
//     let cents = Math.round(amt * 100);
    
//     let quarters = Math.floor(cents / 25);
//     cents -= quarters * 25;
    
//     let dimes = Math.floor(cents / 10);
//     cents -= dimes * 10;
    
//     let nickels = Math.floor(cents / 5);
//     cents -= nickels * 5;
    
//     let pennies = cents; // Remaining cents are all pennies

//     console.log(amt + " dollars can be represented by:\n" + 
//                 "quarters: " + quarters + "\n" + 
//                 "dimes: " + dimes + "\n" + 
//                 "nickels: " + nickels + "\n" + 
//                 "pennies: " + pennies);
// }

// GenerateCoinChange(1.23); // Example usage

// Messy Math Mashup
// Create a function messyMath(num) that will return the following sum: add all integers from 0 up to the given num, except for the following special cases of our count value:

// If current count (not num) is evenly divisible by 3, don’t add to the sum; skip to the next count;
// Otherwise, if the current count is evenly divisible by 7, include it twice in sum instead of once;
// Regardless of the above, if the current count is exactly 1/3 of num, return -1 immediately.
// For example, if given num is 4, return 7. If given num is 8, return 34. If given num is 15, return -1.

// function messyMath(num) {
//     let count = 0;
//     for (let i = 0; i <= num ; i++){
//         if (i == num /3) {
//             return -1
//         }else if(i % 3 === 0){
//             continue;
//         }else if (i % 7 === 0 ){
//             sum += i*2
//         }else{
//             count += i
//         }
//     }
//     return count
// }
// console.log(messyMath(4))


// Twelve-Bar Blues
// Write a function that console.logs the number 1, then "chick", then "boom", then "chick", then 2, then "chick", "boom", "chick" – continuing the same cycle for each number up to (including) 12.

// function twelveBar(){
//     for (let i = 1; i <=12 ; i++){
//         console.log(i);
//         console.log('chick');
//         console.log('boom');
//         console.log('chick')
//     }
// }
// twelveBar();


// Fibonacci
// Create a function to generate Fibonacci numbers. In this famous mathematical sequence, each number is the sum of the previous two, starting with values 0 and 1. Your function should accept one argument, an index into the sequence (where 0 corresponds to the initial value, 4 corresponds to the value four later, etc). 

// Examples: fibonacci(0) = 0 (given), fibonacci(1) = 1 (given), fibonacci(2) = 1 (fib(0)+fib(1), or 0+1), fibonacci(3) = 2 (fib(1)+fib(2), or 1+1), fibonacci(4) = 3 (1+2), fibonacci(5) = 5 (2+3), fibonacci(6) = 8 (3+5), fibonacci(7) = 13 (5+8), etc.

// function Fibonacci(amt){
//     let cal = 0;
//     if(amt == 0 || amt == 1){
//         return amt
//     }else{
//         let a= 0;
//         let b= 1 ;
//         for(let i = 2; i <= amt ; i++){
//             cal = a+ b;
//             a= b;
//             b = cal;
//         }
//         return cal
//     }
// }
// console.log(Fibonacci(6))


// Sum to One Digit
// Kaitlin sees beauty in numbers, but also believes that less is more. Implement sumToOne(num) that sums a given integer’s digits repeatedly until the sum is only one digit. Return that one-digit result. 

// Example: sumToOne(928) returns 1, because 9+2+8 = 19, then 1+9 = 10, then 1+0 = 1.

// function SumtoOneDigit(num){
//     let sum = 0;
//     let temp = num.toString();
//     for (let i = 0; i < temp.length; i++) {
//         sum += Number(temp[i])
//     }
//     return sum;
// }
// console.log(SumtoOneDigit(123))

// Clock Hand Angles
// Regardless of how hard a Dojo student works (and they should work hard), they need time now and then to unwind – like hands on a clock. Traditional clocks are increasingly uncommon, but most can still read an analog clock’s hands of hours, minutes and seconds. Create clockHandAngles(seconds) that, given a number of seconds since 12:00:00, prints angles (in degrees) of the hour, minute and second hands. As a review, 360 degrees form a full rotation. For input of 3600 secs (equivalent to 1:00:00), print "Hour hand: 30 degs. Minute hand: 0 degs. Second hand: 0 degs." For an input parameter seconds of 119730 (which is equivalent to 9:15:30 plus 24 hours!), you should log "Hour hand: 277.745 degs. Minute hand: 93 degs. Second hand: 180 degs." 

// Note: in the second example, the angle for the minute hand is not simply 90 degrees; it has advanced a bit further, because of the additional 30 seconds in that minute so far.

// Second: also calculate and print degrees for an additional “week hand” that rotates once each week.

// function clockHandAngles(seconds) {
//     // Normalize seconds for more than a week
//     seconds = seconds % 604800;

//     // Calculate degrees
//     const secondHandDegrees = (seconds % 60) * 6;
//     const minuteHandDegrees = ((seconds % 3600) / 60) * 360 + ((seconds % 60) * 0.1);
//     const hourHandDegrees = ((seconds % 43200) / 3600) * 360 + ((seconds % 3600) / 60) * 0.5;
//     const weekHandDegrees = (seconds / 604800) * 360;

//     // Print results
//     console.log(`Hour hand: ${hourHandDegrees.toFixed(3)} degs. Minute hand: ${minuteHandDegrees.toFixed(3)} degs. Second hand: ${secondHandDegrees.toFixed(3)} degs. Week hand: ${weekHandDegrees.toFixed(3)} degs.`);
// }

// // Example
// console.log(clockHandAngles(3600)); // 1:00:00
// console.log(clockHandAngles(119730)); // 9:15:30 plus 24 hours!

// Is Prime
// Return whether a given integer is prime. Prime numbers are only evenly divisible by themselves and 1. Many highly optimized solutions exist, but for now, just create one that is easy to understand and debug.

// function isPrime(num){
//     if(num === 2 || num === 3 ){
//         return 'PRIME';
//     }
//     else if ( num % 2 === 0 || num % 3 === 0){
//         return 'Not a prime'
//     }else{
//         return 'Prime'
//     }
// }
// console.log(isPrime(10));



