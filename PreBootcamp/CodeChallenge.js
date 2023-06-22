function calculateOptimalLocation(customers) {
    const numCustomers = customers.length;
    let sumX = 0;
    let sumY = 0;

    for (let i = 0; i < numCustomers; i++) {
        sumX += customers[i][0];
        sumY += customers[i][1];
    }

    const avgX = Math.round(sumX / numCustomers);
    const avgY = Math.round(sumY / numCustomers);

    return [avgX, avgY];
}

console.log(calculateOptimalLocation([[2, 5], [4, 5], [-1, 5], [0, 5]]));

