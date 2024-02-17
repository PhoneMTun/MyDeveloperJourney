// Remove Negatives
// Implement removeNegatives() that accepts an array, removes negative values, and returns the same array (not a copy), preserving non-negatives’ order. As always, do not use built-in array functions.

// let arr = [1, 2, 3, 4, -2, -123, -45]
// function removeNegatives(arr){
//     let temp = 0;
//     for (var i = 0 ; i < arr.length; i++) {
//         if (arr[i]>0) {
//             arr[temp] = arr[i];
//             temp ++;
//         }

//     }
//     arr.length = temp;
//     return arr;
// }

// console.log(removeNegatives(arr))


// Second-to-Last
// Return the second-to-last element of an array. Given [42,true,4,"Kate",7], return "Kate". If array is too short, return null.

// function SecondToRight(arr){
//     if (arr.length<1) {
//         return null;
//     }
//     return arr[arr.length-2]
// }

// console.log(SecondToRight([42,true,4,"Kate",7]))

// Second-Largest
// Return the second-largest element of an array. Given [42,1,4,Math.PI,7], return 7. If the array is too short, return null.

// function SecondLargest(arr){
//     if(arr.lenth < 1) {
//         return null;
//     }
//     const changeset = [...new Set(arr)];
//     changeset.sort((a,b)=> b-a)
//     return changeset[1]
//     console.log(changeset)
// }
// SecondLargest([42,1,4,Math.PI,7])

// Nth-to-Last
// Return the element that is N-from-array’s-end. Given ([5,2,3,6,4,9,7],3), return 4. If the array is too short, return null

// function NthToLast(arr,end){
//     if(arr.length < 1){
//         return null;
//     }
//     return (arr[arr.length - end])
// }

// console.log(NthToLast([5,2,3,6,4,9,7],3))
// Nth-Largest
// Liam has "N" number of Green Belt stickers for excellent Python projects. Given arr and N, return the Nth-largest element, where (N-1) elements are larger. Return null if needed.



// Skyline Heights
// Lovely Burbank has a breathtaking view of the Los Angeles skyline. Let’s say you are given an array with heights of consecutive buildings, starting closest to you and extending away. Array [-1,7,3] would represent three buildings: first is actually out of view below street level, behind it is second at 7 stories high, third is 3 stories high (hidden behind the 7-story). You are situated at street level. Return array containing heights of buildings you can see, in order. Given [-1,1,1,7,3] return [1,7]. Given [0,4] return [4]. As always with challenges, do not use built-in array functions such as unshift().

function Skyline(arr) {
    let see = [];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i]> 0 && see.length === 0 || see[see.length - 1] < arr[i]) {
            see.push(arr[i]);
        }
    }
    return see;
}

console.log(Skyline([0,4]));


