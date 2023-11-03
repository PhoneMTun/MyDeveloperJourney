function isPangram(str) {
    let hashmap = {};
    let result="";

    for (let i = 0; i < str.length; i++) {
        let char = str[i];
        if (hashmap[char]) {
            hashmap[char]++;
        } else {
            hashmap[char] = 1;
        }
    }

    for (let char in hashmap) {
        result += char + hashmap[char];
    }
    return result;
}

console.log(isPangram("aabbccd"));
