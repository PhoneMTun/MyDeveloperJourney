// #1
var arr1 = [8, 6, 7, 5, 3, 0, 9];
// #2
var arr2 = [4, 7, 13, 13, 19, 37, -2];
// #3
var arr3 = [6, 2, 12, 14, -24, 5, 0];

sum1=0, sum2=0, sum3=0;

console.log('XXXXXXXXXXXXXXXXXXXXXXXX PROBMLEM 1 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX');

//question 1
for (var i = 0; i < arr1.length; i++) {
    console.log(arr1[i]);
    
}console.log('-----------------------------------------------------------')

//question 2 
for (var i = 0; i < arr1.length; i++) {
    console.log(arr1[i]+i  );
}console.log('-----------------------------------------------------------')

//question 3 & Bonus
for (var i = 0; i < arr1.length; i++) {
    if (arr1[i] > 5) {
        console.log(arr1[i]);
    }else {
        console.log('No dice');
    }
}


console.log('XXXXXXXXXXXXXXXXXXXXXXXX PROBMLEM 2 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX');

//question 1
for (var i = 0; i < arr2.length; i++) {
    console.log(arr2[i]);
    
}console.log('-----------------------------------------------------------')

//question 2
for (var i = 0; i < arr2.length; i++) {
    console.log(arr2[i]+i);
}console.log('-----------------------------------------------------------')
//question 3 & Bonus
for (var i = 0; i < arr1.length; i++) {
    if (arr2[i] > 5) {
        console.log(arr2[i]);
    }else {
        console.log('No dice');
    }
}
    
console.log('XXXXXXXXXXXXXXXXXXXXXXXX PROBMLEM 3 XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX');

//question 1
for (var i = 0; i < arr3.length; i++) {
    console.log(arr3[i]);
}

//question 2
console.log('-----------------------------------------------------------')
for (var i = 0; i < arr3.length; i++) {
    console.log(arr3[i]+i);
}console.log('-----------------------------------------------------------')
//question 3 & Bonus
for (var i = 0; i < arr3.length; i++) {
    if (arr3[i] > 5) {
        console.log(arr3[i]);
    }else {
        console.log('No dice');
    }
}