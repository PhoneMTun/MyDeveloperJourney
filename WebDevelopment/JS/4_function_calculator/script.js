// var display= document.querySelector('#display').innerText;
// console.log(typeof(display));



// function press(element){
//     // display++;
//     display.innerText = element;
//     console.log(element);
// }

var num1="";
var num2="";
var op="";

var display = document.getElementById('display');
console.log(typeof display);

function press(element) {
    num1+= element;
    display.innerText =num1;
    console.log("num1-" + num1);
}

function setOP(element){
    num2=num1;
    num1='';
    console.log("num2-" + num2);
    op=element;
    console.log(typeof(op));
}

function calculate(){
    let a=parseFloat(num1);
    let b=parseFloat(num2);
    let result=0
    console.log(a);
    console.log(b);
    if (op=='+'){
        result=a+b;
        console.log(result);
    }else if (op=='-'){
        result=a-b;
    }else if (op=='*'){
        result=a*b
    }else if(op=='/'){
        result=a/b
    }
display.innerText=result
}

function clr(){
    num1="";
    num2="";
    op="";
    display.innerText=0
}
