

var add = parseInt(document.querySelector('.circle2').innerText);
var request = parseInt(document.querySelector('.circle').innerText);
var edit = document.querySelector('.editp');
console.log(edit);

console.log(add);
function plus(x){
    var clear = document.querySelector(x);
    clear.remove();
    add++;
    request--;
    document.querySelector('.circle2').innerText=add;
    document.querySelector('.circle').innerText=request;
}
function minus(x){
    var clear = document.querySelector(x);
    clear.remove();
    // add--;
    request--;
    // document.querySelector('.circle2').innerText=add;
    document.querySelector('.circle').innerText=request;
}
function change(){
    edit.innerText="Phone Myat Tun";
}