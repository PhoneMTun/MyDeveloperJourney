// Biggie Size
// Given an array, write a function that changes all positive numbers in the array to “big”. Example: makeItBig([-1,3,5,-5]) returns that same array, changed to [-1,"big","big",-5].

// function BiggieSIze(val){
//     for(let i= 0; i< val.length; i++){
//         if (val[i] >0){
//             val[i]='big'
//         }
        
//     }
//     return val
// }
let val = [-1,3,5,-5]
// console.log(BiggieSIze(val))   


// Print Low, Return High
// Create a function that takes an array of numbers. The function should print the lowest value in the array, and return the highest value in the array.

// function lowhigh(val){
//     let lowest = val[0];
//     let highest = val[0];

//     for (let i = 1 ; i < val.length ; i++){
//         val[i]>highest ? highest = val[i]: lowest = val[i]
//     }
//     return "lowest :" + lowest + " highest :" + highest
//     // let newval = val.sort((a,b) => b-a);
//     // console.log(newval);
// }
// console.log(lowhigh(val))

// Print One, Return Another
// Build a function that takes an array of numbers. The function should print the second-to-last value in the array, and return first odd value in the array.

// function printonereturnarray(val){
//     console.log(val[val.length-2]);
//     for (let i = 1; i < val.length; i++){
//         if (val[i]%2 ==1){
//             console.log(val[i])
//             break;
//         }
//     }
// }
// printonereturnarray(val)

// Double Vision
// Given an array, create a function to return a new array where each value in the original has been doubled. Calling double([1,2,3]) should return [2,4,6] without changing original.

// function doubleVision(val){
//     for (let i = 0 ; i < val.length ; i++){
//         val[i]+=val[i];
//     }
//     return val
// }
// console.log(doubleVision(val));

// Count Positives
// Given an array of numbers, create a function to replace last value with the number of positive values. Example,  countPositives([-1,1,1,1]) changes array to [-1,1,1,3] and returns it.

// function countPositives(val){
//     let total = 0;
//     for (let i = 0 ; i < val.length-1; i++){   
//         total+= val[i];  
//     }
//     val[val.length-1]= total
//     return val
// }
// console.log(countPositives(val))

// Evens and Odds
// Create a function that accepts an array. Every time that array has three odd values in a row, print "That’s odd!" Every time the array has three evens in a row, print "Even more so!"

// function evenAndOdd(val){
//     let even = 0
//     let odd = 0
//     for (let i = 0 ; i < val.length; i ++){
//         if(val[i]%2 === 0 ){
//             even+=1;
//             odd = 0;
//         } 
//         else{
//             odd+=1;
//             even = 0;
//     }
//     if (even ===3 ){
//         console.log('Even more so!!')
//     }else if(odd === 3){
//         console.log('Thats odd!')
//     }
// }

// }
// evenAndOdd(val)

// Increment the Seconds
// Given arr, add 1 to odd elements ([1], [3], etc.), console.log all values and return arr.

// function incrementTheSeconds(arr) {
//     for (let i = 0; i < arr.length; i++) {
//         // Check if the index is odd
//         if (i % 2 !== 0) {
//             arr[i] += 1; // Increment the value at the odd index
//         }
//         console.log(arr[i]); // Log every value
//     }
//     return arr; // Return the modified array
// }

// // Example usage:
// let arr = [0, 1, 2, 3, 4, 5, 6];
// console.log("Modified array:", incrementTheSeconds(arr));

// Previous Lengths
// You are passed an array containing strings. Working within that same array, replace each string with a number – the length of the string at previous array index – and return the array.
