//Setting and Swapping
// var mynumber = 422
// var myname = "Phone Myat Tun"
// mynumber, myname = myname, mynumber

// console.log("mynumber: " +mynumber)
// console.log("myname: " +myname)

//Print -52 to 1066

// for (var i = -52; i <=1066; i++) {
//     console.log(i)
// }

//Dont Worry, Be Happy
// const beCheerful = ()=>{
//     console.log("Good Moring!");
// }
// beCheerful()

//Multiple of 3

// for (var i =-300; i<=0; i+=3) {
//     if (i == -3 || i == -6){
//         continue;
//     }
//     console.log(i)
// }

//printing intergers with while

// var i = 2001;

// while (i <= 5280) {
//     console.log(i);
//     i++;
// }

//You say its your birthday

// var birthMonth = 1;
// var birthDay = 15; 

// var givenNumber1 = 15; 
// var givenNumber2 = 1; 

// if ((givenNumber1 === birthMonth && givenNumber2 === birthDay) || (givenNumber1 === birthDay && givenNumber2 === birthMonth)) {
//     console.log("How did you know?");
// } else {
//     console.log("Just another day....");
// }

//Leap Year

// const leapyear=(i)=>{
//     if((i%4==0 && i % 100 !== 0) || i % 400 === 0) {
//         console.log("It is a leap year");
//     }else{
//         console.log("Nope");
//     }
// }
// leapyear(100)

// Print and count
// let count=0;
// for (var i=512; i<=4096; i+=5){
//     count+=1;
// }
// console.log(count);

// Mutiple of 6
// let i = 6;
// while(i<=60000){
//     i+=6;
//     console.log(i);
// }

// Counting the Dojo Way

// for(var i=1; i<=100; i++){
//     if (i%10===0) {
//         console.log("Dojo");
//     }else if(i %5 === 0) {
//         console.log("Coding");
//     }else{
//         console.log(i)
//     }
// }

// What do you know
// function test(thisvalue){
//     console.log(thisvalue);
// }
// test(1)

// Whoa, That Sucker's huge
// let sum=0;
// for (var i=-300000; i<=300000; i++){
//     if (i%2!==0){
//         sum+=i
//     }
// }
// console.log(sum)

//Countdown by Fours
// let i = 2016
// while (i != 0){
//     console.log(i)
//     i-=4
// }

// Flexible Countdown
// let lowNum = 2;
// let highNum = 9;
// let mult = 3;

// for (let num = highNum; num >= lowNum; num -= mult) {
//     console.log(num);
// }

//THe final Countdown

// let param1 = 3;
// let param2 = 5;
// let param3 = 17;
// let param4 = 9;

// let currentNumber = param2;

// while (currentNumber <= param3) {
//     if (currentNumber % param1 === 0 && currentNumber !== param4) {
//         console.log(currentNumber);
//     }
//     currentNumber++;
// }



let param1, param2, param3, param4;
param1 = 3;
param2 = 5;
param3 = 17;
param4 = 9;

let i = param2;

while (i <= param3) {
    if (i % param1 === 0) {
        if (i % param4 === 0) {
            i++;
            continue;
        }
        console.log(i);
    }
    i++;
}
