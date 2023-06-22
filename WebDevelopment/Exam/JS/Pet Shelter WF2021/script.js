var number1=parseInt(document.querySelector('.num1').innerText);
var number2=parseInt(document.querySelector('.num2').innerText);
var number3=parseInt(document.querySelector('.num3').innerText);
// var number1=parseInt(document.querySelector('.num1').innerText);
// console.log(typeof(number1));
// console.log(number1);

function hide(element) {
    element.remove()    
}

function change(element) {
    alert('You are looking for a: ' + element.value);
}

function press(){
    number1++;
    document.querySelector('.num1').innerText=number1;
    console.log(number1);
}
function press1(){
    number2++;
    document.querySelector('.num2').innerText=number2;
    console.log(number1);
}
function press2(){
    number3++;
    document.querySelector('.num3').innerText=number3;
    console.log(number1);
}