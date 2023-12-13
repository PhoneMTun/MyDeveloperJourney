const BankAccount = require('./BankAccount');

class User {
    constructor(name, email) {
        this.name = name;
        this.email = email;
        this.account = new BankAccount(0.02, 0);
    }

    process() {
        
        this.account.deposit(100); 
        console.log(`Successfully deposited $100 to the account. New balance: ${this.account.balance}`);

        this.account.withdraw(50); 
        console.log(`Successfully withdrawn $50 from the account. New balance: ${this.account.balance}`);
    }
}

const Phone = new User("Phone", "hanminsoe10@gmail.com");
const Tun = new User("Tun", "Tun@gmail.com");


Phone.process();
Tun.process();
