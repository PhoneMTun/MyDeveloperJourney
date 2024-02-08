// Sigma
// Implement function sigma(num) that given a number, returns the sum of all positive integers up to number (inclusive). Ex.: sigma(3) = 6 (or 1 + 2 + 3); sigma(5) = 15 (or 1 + 2 + 3 + 4 + 5).

    let sum = 1;
// function sigma(num) {
//     for (var i = 1; i <= num; i++) {
//             sum+= i
//         }
//         return sum
// }

// console.log(sigma(3))

// Factorial
// Just the Facts, ma’am. Factorials, that is. Write a function factorial(num) that, given a number, returns the product (multiplication) of all positive integers from 1 up to number (inclusive). 

// For example, factorial(3) = 6 (or 1 * 2 * 3); factorial(5) = 120 (or 1 * 2 * 3 * 4 * 5).

// function factorial(num){
//     for (var i = 1; i <= num; i++) {
//     sum *= i
// }
// return sum
// }
// console.log(factorial(3))

// Star Art
// Assume that you have a text field that is exactly 75 characters long. You want to fill it with spaces and asterisks ('*'), sometimes called stars. You should print the given number of asterisks consecutively. Depending on which function is called, those stars should be left-justified (the first star would be very first char in the text field), or right-justified (the last star would be very last char in the text field, with potentially some number of spaces at beginning of text field before the block of stars start), or centered in the 75- character text field (with the same number of spaces on either side of the block of stars, plus/minus one).

// Write a function drawLeftStars(num) that accepts a number and prints that many asterisks.
// Write a function drawRightStars(num) that prints 75 characters total. Stars should build from the right side. The last num characters should be asterisks; the other 75 should be spaces.   
// Write function drawCenteredStars(num) that prints 75 characters total. The stars should be centered in the 75. The middle num characters should be asterisks; the rest of the 75 spaces.
// (Optional) Create epic text-art Empire vs. Rebellion battle scenes, with ships like (=*=)and >o<.

// function drawLeftStars(num) {
//     for (let i = 1; i <= num; i++) {
//         let stars = '';
//         for (let j = 0; j < i; j++) {
//             stars += '*';
//         }
//         console.log(stars);
//     }
// }
// drawLeftStars(75);

// function drawRightStars(num) {
//     for (let i = 1; i <= num; i++) {
//         let line = '';
//         // Add spaces
//         for (let j = 1; j <= num - i; j++) {
//             line += ' ';
//         }
//         // Add stars
//         for (let k = 1; k <= i; k++) {
//             line += '*';
//         }
//         console.log(line);
//     }
// }
// drawRightStars(5);

function drawCenteredStars(num) {
    for (let i = 1; i <= num; i++) {
        let line = '';
        // Add leading spaces to center the stars
        for (let j = 1; j <= num - i; j++) {
            line += ' ';
        }
        // Add stars: for each row, the number of stars is (2*i - 1)
        for (let k = 1; k <= 2 * i - 1; k++) {
            line += '*';
        }
        console.log(line);
    }
}
drawCenteredStars(5);

