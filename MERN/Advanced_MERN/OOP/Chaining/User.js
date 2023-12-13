class User {
    constructor(username, emailAddress) {
        this.name = username;
        this.email = emailAddress;
        this.accountBalance = 0;
    }

    makeDeposit(amount){
        this.accountBalance += amount
    }
    makeWithdraw(amount){
        this.accountBalance -= amount
    }
    displaybalance(){
        console.log(`The remaining balance on ${this.name} account balance is ${this.accountBalance}`);
    }
    transfermoney(amount, Other){
        this.makeWithdraw(amount)
        Other.accountBalance += amount;
        console.log("Successfully transferred!!");
    }
}

const Jerry = new User("Jerry", "Jerry@gmail.com")
const Tom = new User("Tom", "Tom@gmail.com")
const Susan = new User("Susan", "Susan@gmail.com")


Jerry.makeDeposit(1000)
Jerry.makeDeposit(100)
Jerry.makeDeposit(100)
Jerry.makeWithdraw(200)
Jerry.displaybalance()

// Tom.makeDeposit(1000)
// Tom.makeDeposit(1000)
// Tom.makeWithdraw(200)
// Tom.makeWithdraw(200)
// Tom.displaybalance()

// Susan.makeDeposit(1000)
// Susan.makeWithdraw(200)
// Susan.makeWithdraw(200)
// Susan.makeWithdraw(200)
// Susan.displaybalance()

Jerry.transfermoney(50, Susan);

Jerry.displaybalance()
Susan.displaybalance()