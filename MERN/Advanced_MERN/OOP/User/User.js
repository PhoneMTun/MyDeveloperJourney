class User {
    constructor(username, emailAddress) {
        this.name = username;
        this.email = emailAddress;
        this.accountBalance = 0;
    }

    makeDeposit(amount){
        this.accountBalance += amount
        return this
    }
    makeWithdraw(amount){
        this.accountBalance -= amount
        return this
    }
    displaybalance(){
        console.log(`The remaining balance on ${this.name} account balance is ${this.accountBalance}`);
        return this
    }
    transfermoney(amount, Other){
        this.makeWithdraw(amount)
        Other.accountBalance += amount;
        console.log("Successfully transferred!!");
        return this
    }
}

const Jerry = new User("Jerry", "Jerry@gmail.com")
const Tom = new User("Tom", "Tom@gmail.com")
const Susan = new User("Susan", "Susan@gmail.com")


Jerry.makeDeposit(1000).makeDeposit(100).makeDeposit(100).makeWithdraw(200).displaybalance()

Tom.makeDeposit(1000).makeDeposit(1000).makeWithdraw(200).makeWithdraw(200).displaybalance()


Susan.makeDeposit(1000).makeWithdraw(200).makeWithdraw(200).makeWithdraw(200).displaybalance()


Jerry.transfermoney(50, Susan);

Jerry.displaybalance()
Susan.displaybalance()