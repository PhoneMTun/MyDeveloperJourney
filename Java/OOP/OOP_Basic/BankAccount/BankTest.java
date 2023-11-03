public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();
        
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println("Enter the amount to deposit: >>>>");
        String amount = System.console().readLine();
        System.out.println("Which account to deposit");
        System.out.println("A: CHECKING       B: SAVINGS"); ;
        String account = System.console().readLine();
        account1.deposit(Double.parseDouble(amount), account.toLowerCase());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        System.out.println("Enter the amount to withdraw: >>>>");
        String withDrawamount = System.console().readLine();
        System.out.println("Which account to withdraw: >>>>");
        System.out.println("A: CHECKING       B: SAVINGS"); ;
        String withDrawAcc = System.console().readLine();
        account1.withdraw(Double.parseDouble(withDrawamount), withDrawAcc.toLowerCase());

        // Static Test (print the number of bank accounts and the totalMoney)
        account1.getBalance();

    }
}
