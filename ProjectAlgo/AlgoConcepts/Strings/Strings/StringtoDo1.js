// Strings To Do 1
// Write functions using the JavaScript language for all challenges. Use only a single JavaScript file for this assignment. Do not use built-in methods (unless otherwise instructed). (.length is a property, and is allowed.)

// Remove Blanks
// Create a function that, given a string, returns all of that string’s contents, but without blanks. 

// Examples:

// removeBlanks(" Pl ayTha tF u nkyM usi c ") => "PlayThatFunkyMusic"
// removeBlanks("I can not BELIEVE it's not BUTTER") => "IcannotBELIEVEit'snotBUTTER"

function removeBlanks(str){
    var newstr='';
    for (var i = 0; i <str.length; i++) {
            if(str[i]===' '){
                continue;
            }
            newstr +=str[i];
        

}
console.log(newstr)

}


removeBlanks(" Pl ayTha tF u nkyM usi c ") 
removeBlanks("I can not BELIEVE it's not BUTTER")





// Get Digits
// Create a JavaScript function that given a string, returns the integer made from the string’s digits. You are allowed to use isNaN() and Number().

// Examples:



function getDigits(str){
    newstr=''; 
    for(var i=0; i<str.length; i++) {
        if(isNaN(str[i])){
            continue;
        }
        newstr+= str[i]
    }
    console.log(newstr)
}

getDigits("abc8c0d1ngd0j0!8") 

getDigits("0s1a3y5w7h9a2t4?6!8?0")

// Acronyms
// Create a function that, given a string, returns the string’s acronym (first letter of the word capitalized). You are allowed to use .split() and .toUpperCase().



function acronym(str){
    newstr='';
    let words = str.split(' ')
    for(var i = 0; i < words.length; i++) {
        newstr+=words[i][0]
    }
    console.log(newstr.toUpperCase())
}
acronym(" there's no free lunch - gotta pay yer way. ")

acronym("Live from New York, it's Saturday Night!")


// Count Non-Spaces
// Create a function that, given a string, returns the number of non-space characters found in the string. 

// Examples:

// countNonSpaces("Honey pie, you are driving me crazy") => 29
// countNonSpaces("Hello world !") => 11

function  countNonSpaces(str){
    count = 0
    for (var i = 0; i < str.length; i++){
        if (str[i]==' '){
            continue;
        }
        count++;
    }
    return count;
}

console.log(countNonSpaces("Honey pie, you are driving me crazy"))
console.log(countNonSpaces("Hello world !"))

// Remove Shorter Strings
// Create a function that, given an array of strings and a numerical value, returns an array that only contains strings longer than or equal to the given value.

// Examples:

// removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4) => ['Good morning', 'sunshine', 'Earth', 'says', 'hello']
// removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3) => ['There', 'bug', 'the', 'system']

function removeShorterStrings(arr , val){
    var newarr = [];
    for(var i = 0 ; i <arr.length; i++){
        if (arr[i].length>=val){
            newarr.push(arr[i])
        }
    }
    return newarr
}
console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4))