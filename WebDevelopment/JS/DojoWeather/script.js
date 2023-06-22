
function hide() {
    var cookie = document.querySelector('.cookie-container')
    cookie.remove();
}

function CTF(temp) {
    return Math.round((temp * 9/5) + 32)
}

function loading() {
    alert('Loading weather report...');
}
function CTC(temp){
    return Math.round(5 / 9 * (temp - 32));
}

function convert(element) {
    console.log(element.value);
    for(var i=1; i<9; i++) {
        var tempSpan = document.querySelector("#temp" + i);
        var tempVal = parseInt(tempSpan.innerText);
        if(element.value == "°C") {
            tempSpan.innerText = CTC(tempVal);
        } else {
            tempSpan.innerText = CTF(tempVal);
        }
    }
}