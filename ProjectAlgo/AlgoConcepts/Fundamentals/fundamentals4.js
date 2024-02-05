// Only Keep the Last Few
// Stan learned something today: that directly decrementing an array’s .length immediately shortens it by that amount. Given array arr and number X, remove all except the last X elements, and return arr (changed and shorter). Given ([2,4,6,8,10],3), change the given array to [6,8,10] and return it.

arr= [2,4 ,6 ,8, 10];
val = 3;

function onlyKeepTheLastFew(arr,val){
    for (let i= 0 ; i<arr.length; i++){
        if (i == val+1 ){
            arr.length = val
            break
        }
        arr[i]= arr[arr.length-val+i]
    }
    return arr
    
}
console.log(onlyKeepTheLastFew(arr,val))


// Math Help
// Cartman doesn’t really like math; he needs help. You are given two numbers – coefficients M and B in the equation Y = MX + B. Build a function to return the X-intercept (his older cousin Fiaz wisely reminds him that X-intercept is the value of X where Y equals zero; Cartman just snorts in his general direction).

// function mathHelp (M,B){
//     M  == 0?  "Its a horizonal line" : -B/M
// }