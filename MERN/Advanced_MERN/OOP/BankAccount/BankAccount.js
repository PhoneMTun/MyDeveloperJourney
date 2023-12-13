class BankAccount {
    constructor(intRate, balance) {
        this.intRate = intRate;
        this.balance = balance;
    }

    deposit(amount) {
        this.balance += amount;
        return this;
    }

    withdraw(amount) {
        if (amount > this.balance) {
            console.log("Not enough funds. Charging a 5 dollars fee.");
            this.balance -= 5;
        } else {
            this.balance -= amount;
        }
        return this;
    }

    displayAccountInfo() {
        console.log(`Balance: ${this.balance}`);
        return this;
    }

    yieldInterest() {
        if (this.balance > 0) {
            this.balance += this.balance * this.intRate;
        }
        return this;
    }
}

const Phone = new BankAccount(0.05, 1000000);
const Tun = new BankAccount(0.05, 50000);
Phone.deposit(100).deposit(200).deposit(500).withdraw(500).yieldInterest().displayAccountInfo();
Tun.deposit(100).deposit(200).withdraw(500).withdraw(500).withdraw(500).withdraw(500).yieldInterest().displayAccountInfo();
