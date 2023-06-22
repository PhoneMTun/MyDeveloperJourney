function rotateArray(arr, n) {
    for (let i = 0; i < n; i++) {
      const lastElement = arr.pop();
      arr.unshift(lastElement);
    }
    return arr;
}
  rotateArray([1, 2, 3, 4, 5, 6],2)