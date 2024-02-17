// Credit Card Validation
// The Luhn formula is sometimes used to validate credit card numbers. Create the function isCreditCardValid(digitArr) that accepts an array of digits on the card (13-19 depending on the card), and returns a boolean whether the card digits satisfy the Luhn formula, as follows:

// Set aside the last digit; do not include it in these calculations (until step 5);
// Starting from the back, multiply the digits in odd positions (last, third-to-last, etc.) by 2;
// If any results are larger than 9, subtract 9 from them;
// Add all numbers (not just our odds) together;
// Now add the last digit back in – the sum should be a multiple of 10.
// For example, when given digit array [5,2,2,8,2], after step 1) it becomes [5,2,2,8], then after step 2) it is [5,4,2,16]. Post-3) we have [5,4,2,7], then following 4) it becomes 18. After step 5) our value is 20, so ultimately we return true. If the final digit were any non-multiple-of-10, we would instead return false.



function CreditCardValid(digitArr) {
    let sum = 0;
    const lastDigit = digitArr[digitArr.length - 1]; // Save the last digit
    for (let i = digitArr.length - 2; i >= 0; i--) { // Start from the second-to-last digit
        let digit = digitArr[i];
        if ((digitArr.length - 2 - i) % 2 == 0) { // Check positions from the right, excluding the last digit
            digit = digit * 2;
            if (digit > 9) {
                digit -= 9;
            }
        }
        sum += digit; // Add modified or original digit to sum
    }

    sum += lastDigit; // Add the last digit back to the sum
    console.log(digitArr); // Optionally log the original array (or modified digits if desired)
    console.log(sum); // Log the final sum for debugging
    return sum % 10 === 0; // Check if the sum is a multiple of 10
}

// Example usage
const digitArr = [4, 5, 2, 2, 8, 2]; // Example card number array
console.log(CreditCardValid(digitArr)); // Outputs true or false
