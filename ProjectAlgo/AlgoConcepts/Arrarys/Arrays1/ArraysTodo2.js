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

// function rotateArr(arr, shiftBy){
//     for( let i = 0; i< arr.length; i++){
//         if (i+shiftBy <= arr.length-1){
//             [arr[i], arr[i+shiftBy]] = [arr[i+shiftBy], arr[i] ]
//         }
//         else{
//             [arr[i], arr[shiftBy-(arr.length-1-i)-1]]=[ arr[shiftBy-(arr.length-1-i)-1], arr[i]]
//         }
//     }
//     return arr
// }
// console.log(rotateArr([1,2,3], 3))


// Filter Range

// Alan is good at breaking secret codes. One method is to eliminate values that lie outside of a specific known range. Given arr and values min and max, retain only the array values between min and max. Work in-place: return the array you are given, with values in original order. No built-in array functions.

// function filterarr (arr, min , max) {
//     let newarr = [];
//     for (var i = 0; i < arr.length ; i++) {
//         if (arr[i]<min || arr[i]>max){
//             continue;
//         }
//         newarr.push(arr[i])
//     }
//     return newarr
// }

// console.log(filterarr([5,2,45,2,3,4,5],2 ,3))


// Concat
// Replicate JavaScript's concat(). Create a standalone function that accepts two arrays. Return a new array containing the first array's elements, followed by the second array's elements. Do not alter the original arrays. Ex.: arrConcat( ['a','b'], [1,2] ) should return new array ['a','b',1,2].


// function arrConcat (arr1, arr2) {
//     for (var i = 0; i < arr2.length; i++) {
//         arr1.push(arr2[i]);
//     }
//     return arr1;
// }
// console.log(arrConcat(['a'],[1,2,3]))