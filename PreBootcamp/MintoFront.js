
function minToFront(arr) {
    var smallest=arr[0];
    var minIndex=0;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < smallest) {
            smallest=arr[i];
            minIndex=i;
        }
        
    }
    for (var j=minIndex; j>0; j--){
        arr[j]=arr[j-1];
    }

    arr[0]=smallest;
    return arr;
}


console.log(minToFront([4,2,3,1])); 