function popFront(arr){
    let first= arr[0]
    for (var i=1; i<arr.length; i++){
        arr[i-1]= arr[i];
    }
    arr.length -=1;
    console.log(arr)
    return first
}
console.log(popFront(1,2,3))