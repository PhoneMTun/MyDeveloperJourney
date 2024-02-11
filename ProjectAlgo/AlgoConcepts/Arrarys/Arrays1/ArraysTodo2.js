// Reverse
// Given a numerical array, reverse the order of values, in-place. The reversed array should have the same length, with existing elements moved to other indices so that order of elements is reversed. Working 'in-place' means that you cannot use a second 
// array – move values within the array that you are given. As always, do not use built-in array functions such as splice().

// function sortarr(arr){
//     for (var i = 0; i < arr.length; i++){
//         for (var j = i+1; j < arr.length; j++){
//             if(arr[j] > arr[i]){
//                 [arr[j], arr[i]]=[arr[i], arr[j]]
//             }

//         }
//     }
//     return arr
// }
    
// console.log(sortarr([4,5,3,2,4,1]))


// function sortarr(arr){
//     let start  = 0;
//     let end  = arr.length -1;
//     while(start < end){
//         [arr[start], arr[end]] = [arr[end], arr[start]]
//         start ++;
//         end --;
//     }
//     return arr
// }
// console.log(sortarr([5,4,3,2,1]))


// Rotate
// Implement rotateArr(arr, shiftBy) that accepts array and offset. Shift arr's values to the right by that amount. 'Wrap-around' any values that shift off array's end to the other side, so that no data is lost. Operate in-place: given ([1,2,3],1), 
// change the array to [3,1,2]. Don't use built-in functions.
// Second: allow negative shiftBy (shift L, not R).
// Third: minimize memory usage. With no new array, handle arrays/shiftBys in the millions.
// Fourth: minimize the touches of each element.

function rotateArr(arr, shiftBy){
    for( let i = 0; i< arr.length ;i++){
        if (i+shiftBy <= arr.length-1){
            [arr[i], arr[i+shiftBy]] = [arr[i+shiftBy], arr[i] ]
        }
        else{
            [arr[i], arr[shiftBy-(arr.length-1-i)-1]]=[ arr[shiftBy-(arr.length-1-i)-1], arr[i]]
        }
    }
    return arr
}
console.log(rotateArr([1,2,3], 3))

