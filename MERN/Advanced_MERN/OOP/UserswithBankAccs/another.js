const BankAccount = require('./BankAccount');
class User{
    constructor(name, email){
        this.name = name;
        this.email = email;
        this.account = [];
    }
    add_acoount(intRate, balance){
        let newAccount = new BankAccount(intRate, balance);
        this.account.push(newAccount);
        return this;
    }
    makeWithdrawal(amount, index) {
        if (index < this.account.length) {
            if (amount <= this.account[index].balance) {
                this.account[index].withdraw(amount);
            } else {
                console.log("Not enough funds. Charging a 5 dollars fee.");
                this.account[index].balance -= 5;
            }
        } else {
            console.log("Account not found");
        }
    }

    }
