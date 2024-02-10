// Rockin’ the Dojo Sweatshirt
// Ever since you arrived at the Dojo, you wanted one of those cool Coding Dojo sweatshirts – maybe even more than one. Let’s say they cost $20 (including tax), but friendly Josh gives a 9% discount if you buy two, a nice 19% discount if you buy three, or a sweet 35% discount if you buy four or more. He only accepts cash and says he doesn’t have coins, so you should round up to the nearest dollar. Build function sweatshirtPricing(num) that, given a number of sweatshirts, returns the cost.

function sweatshirtPricing(num) {
    let pricePerShirt = 20;
    let totalCost;

    if (num == 1) {
        totalCost = pricePerShirt * num; // No discount for one sweatshirt
    } else if (num == 2) {
        totalCost = (pricePerShirt * num) * (1 - 0.09); // 9% discount for two
    } else if (num == 3) {
        totalCost = (pricePerShirt * num) * (1 - 0.19); // 19% discount for three
    } else if (num >= 4) {
        totalCost = (pricePerShirt * num) * (1 - 0.35); // 35% discount for four or more
    }

    return `This is the price for ${num} shirts: $${Math.ceil(totalCost)}`;
}

console.log(sweatshirtPricing(2)); // Corrected function call
