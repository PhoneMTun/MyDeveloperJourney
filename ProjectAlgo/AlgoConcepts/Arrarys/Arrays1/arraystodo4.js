// Shuffle
// In JavaScript, the Array object has numerous useful methods. It does not, however, contain a method that will randomize the order of an array’s elements. Let’s create shuffle(arr), to efficiently shuffle a given array’s values. Work in-place, naturally. Do you need to return anything from your function?


// function shuffle(arr) {
//     for (let i = arr.length-1; i> 0; i--) {
//         const j = Math.floor(Math.random() * (i+1) );
//         [arr[i], arr[j]] = [arr[j], arr[i]];
//     }
//     return arr;   
// }

// console.log(shuffle([1,2,3,4,5]))


// Remove Range
// Given array, and indices start and end, remove vals in that index range, working in-place (hence shortening the array). Given ([20,30,40,50,60,70],2,4), change to [20,30,70] and return it.


// function range(arr,strt,end){
//     arr.splice(strt, end-strt+1)
//     return arr
// }

// console.log(range([20,30,40,50,60,70],2,4))

// Intermediate Sums
// You will be given an array of numbers. After every tenth element, add an additional element containing the sum of those ten values. If the array does not end aligned evenly with ten elements, add one last sum that includes those last elements not yet been included in one of the earlier sums. Given the array [1,2,1,2,1,2,1,2,1,2,1,2,1,2], change it to [1,2,1,2,1,2,1,2,1,2,15,1,2,1,2,6]

// function intermediateSum(arr){
//     let sum = 0;
//     for (var i=0; i < arr.length; i++){
//         sum += arr[i]
//         if(i == 9  || i ==arr.length-1){
//             arr.splice(i+1,0, sum)
//             sum = 0
//             i++;

//         }
//         console.log(sum ,i)
//         console.log(arr.length)
        
//     }
//     return arr

// }
// console.log(intermediateSum([1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2]))

// Double Trouble
// Create a function that changes a given array to list each original element twice, retaining original order. Convert [4,"Ulysses",42,false] to [4,4,"Ulysses","Ulysses",42,42,false,false].

// function doubleTrouble(arr){
//     for(let i=0; i<arr.length; i+=2){
//         arr.splice(i+1, 0, arr[i])
        
//     }
//     return arr
// }
// console.log(doubleTrouble([4,"Ulysses",42,false]))

// Zip It
// Create a standalone function that accepts two arrays and combines their values sequentially into a new array, at alternating indices starting with first array. Extra values from either array should be included afterward. Given [1,2] and [10,20,30,40], return new array containing [1,10,2,20,30,40].

// Second: combine the two arrays’ values into the first array, instead of into a new array. Much more fun!

function zipIt(arr1, arr2) {
    let maxLength = Math.max(arr1.length, arr2.length); // Use Math.max to find the longer array length
    let result = []; // Initialize an empty array to hold the result

    for (let i = 0; i < maxLength; i++) {
        if (i < arr1.length) { // Check if the current index is within the bounds of arr1
            result.push(arr1[i]);
        }
        if (i < arr2.length) { // Check if the current index is within the bounds of arr2
            result.push(arr2[i]);
        }
    }

    return result;
}

console.log(zipIt([1, 2], [10, 20, 30, 40])); // Output: [1, 10, 2, 20, 30, 40]
