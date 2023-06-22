function popFront(arr) {
    var firstValue = arr[0];
    for (var i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = undefined;
    arr.pop();
    return firstValue;
  }
  
  // Example usage
  var array = [5, 93, 22, 4];
  var removedValue = popFront(array);
  
  console.log(removedValue); 
  console.log(array); 
  