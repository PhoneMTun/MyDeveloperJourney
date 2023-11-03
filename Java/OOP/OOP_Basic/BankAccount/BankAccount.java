import java.util.Random;
public class BankAccount {

    // MEMBER VARIABLESS
    private int accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts=0;
    private static double totalMoney=0; // refers to the sum of all bank account checking and savings balances
    
    // private method for generatingiD
    private static int generateID(){
        Random rand = new Random();
        int randID = rand.nextInt(999999999)+1000000000;
        return randID;
    }
    // CONSTRUCTOR
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance= 0;
        accounts+=1;//increment the number of accounts
        this.accountNumber =BankAccount.generateID();
    }
    // GETTERS
    // for checking balance
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    // for getsaving balance
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    // for accounts
    public int getAccounts() {
        return accounts;
    }// for total money
    public double getTotalMoney() {
        return totalMoney;
    }
    public int AccNumber(){
        return this.accountNumber;
    }
    // METHODS

    // deposit money into their checking or savings account
    public void deposit(double amount, String account){
        
        if (account.equals("a")){
            this.checkingBalance+=amount;
        }
        if (account.equals("b")){
            this.savingsBalance+=amount;
        }
        totalMoney+=amount;
        System.out.println("Deposited");
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    //canoot withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void withdraw(double amount, String account) {
        
        if (account.equals("a") && this.checkingBalance < amount) {
            System.out.println("Insufficient funds in checking account");
            return;
        }
        if (account.equals("b") && this.savingsBalance < amount) {
            System.out.println("Insufficient funds in savings account");
            return;
        }
        if (account.equals("a")){
                this.checkingBalance-=amount;
        }
        if (account.equals("b")){
                this.savingsBalance-=amount;
        }
        totalMoney-=amount;
        System.out.println("withdrawn successful");
    }
    

    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public void getBalance() {
        System.out.printf("checkingBalance: %s, savingsBalance: %s, totalMoney: %s", this.checkingBalance,this.savingsBalance, totalMoney);
}
}
