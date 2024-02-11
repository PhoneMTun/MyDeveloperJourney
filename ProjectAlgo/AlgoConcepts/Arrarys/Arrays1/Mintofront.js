// Min to Front
// Given an array of comparable values, move the lowest element to array’s front, shifting backward any elements previously ahead of it. Do not otherwise change the array’s order. Given [4,2,1,3,5], change it to [1,4,2,3,5] and return it. As always, do this without using built-in functions.


function sortarr(arr){
    for (var i = 0; i < arr.length; i++){
        for (var j = i+1; j < arr.length; j++){
            if(arr[j] < arr[i]){
                [arr[j], arr[i]]=[arr[i], arr[j]]
            }

        }
    }
    return arr
}

console.log(sortarr([4,5,3,2,4,1]))