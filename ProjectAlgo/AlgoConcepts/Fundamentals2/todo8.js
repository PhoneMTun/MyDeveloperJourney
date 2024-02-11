// Gaming Fun(damentals)
// It’s New Year’s Eve, so let’s play some dice games! It’ll be fun. What could go wrong?

// Create function rollOne() to return a randomly selected integer between 1 and 6 (inclusive).   
// Second, create a function playFives(num), which should call rollOne() multiple times –  ‘num' times, in fact, where 'num' is input parameter to playFives(num). Each time, it should print the value rollOne() returns, and if that return value is 5, also print “That’s good luck!”
// Third, create a new function named playStatistics(), which should call rollOne() eight times (but not print anything after each call). After the last of these eight calls, it should print out the lowest and highest values that it received from rollOne, among those eight calls.
// Fourth, make a copy of playStatistics and add code to make playStatistics2(), so that at the end (in addition to printing high/low rolls), it also prints the total sum of all eight rolls.
// Fifth, copy playStatistics2 and add code to it to make playStatistics3(num), so that it will roll as many times as you want, instead of always doing this eight times.
// Finally, make a copy of playStatistics3 and change it to create playStatistics4(num), so that at the end instead of the total sum, it prints the average roll.

function rollOne(){
    let num = Math.floor(Math.random()*(6-1+1)+1);
    return num
}
function playFives(num){
    for (let i = 0; i < 10; i++){
        if (rollOne() === num){
            return 'Thats good luck!!!!!!'
        }
    }
}
playFives(2)