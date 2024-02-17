// Arrays To Do 5


// Average (Warmup)
// (Warm-up) Always run through some quick algorithm problems before any coding interview, to get yourself warmed up. How about this one: return the average value of an array of unsorted numbers.
// function averagearr(arr) {
//     let sum = 0;
//     for (var i = 0; i < arr.length; i++) {
//         sum += arr[i]
//     } 
//     return sum/arr[arr.length - 1];
// }
// console.log(averagearr([1,2,3,4,5]))


// Balance Point
// Write a function that returns whether the given array has a balance point between indices, where one side’s sum is equal to the other’s. Example: [1,2,3,4,10] → true (between indices 3 & 4), but [1,2,4,2,1] → false.
// function BalancePoint(arr){
//     let totalSum  = arr.reduce((acc, val)=> acc +val , 0);
//     let leftSum = 0;
//     let rightSum = 0;
//     for (let i=0; i<arr.length; i++) {
//         leftSum += arr[i];
//         rightSum = totalSum - leftSum
//         if (rightSum == leftSum ){
//             return true;
//         }
//     }
//     return false;
// }
// console.log(BalancePoint([1, 2, 3, 4, 10])); // Output: true
// console.log(BalancePoint([1, 2, 4, 2, 1])); // Output: fals


// Balance Index
// Here, a balance point is on an index, not between indices. Return the balance index where sums are equal on either side (exclude its own value). Return -1 if none exist. Ex.: [-2,5,7,0,3] → 2, but [9,9] → -1.

// function BalancePoint(arr){
//     if(arr.legnth%2 == 0){
//         return -1
//     }
//     let totalSum   = arr.reduce((acc, val)=>acc + val, 0);
//     console.log(totalSum); //
//     let sumleft = 0;
//     let sumright = 0;
//     for (let i=0; i<arr.length; i++){
//         sumleft += arr[i];
//         sumright = totalSum - sumleft
//         // console.log(sumleft, sumright);
//         if (sumleft-arr[i]==sumright){
//             return i
//         }
//     }
//     return -1
// }
// console.log(BalancePoint([-2,5,7,0,3]))