var newarr=[];
var minValue=Infinity;
function minToFront(arr) {

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < arr[i+1]) {
            newarr.push(arr[i]);
        }
    }
    console.log(newarr);
}
minToFront([4,2,3,1]) 