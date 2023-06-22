var list1= ['ice cream', 'cookes', 'candy']
var list2= ['hot chocolate', 'tea', 'cake']

var selection1=list1[Math.floor(Math.random()*list1.length)];
var selection2=list2[Math.floor(Math.random()*list2.length)];
function icecream(day,time) {
    if (day=='wednesday'){
        if(time==3||time==4||time==5||time==6){
            if(time%2==0){
            console.log(selection1);
            }else{
            console.log(selection2);
        }
    }
    else {
        console.log('vanilla ice cream');
    }
}
}
icecream('wednesday',4);