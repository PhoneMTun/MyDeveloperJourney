class BankAccount:
    # don't forget to add some default values for these parameters!
    all_accounts =[]
    def __init__(self,int_rate=0.0,balance=0.0): 
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_accounts.append(self)
        # your code here! (remember, instance attributes go here)
        # don't worry about user info here; we'll involve the User class soon
    def deposit(self, amount):
        self.balance += amount
        return self

        # your code here
    def withdraw(self, amount):
        if self.balance<amount:
            print ("insufficient funds: Charging a $5 fee")
            self.balance -=5
        else:
            self.balance -= amount
        return self
        # your code here
    def display_account_info(self):
        print (f"Balance: ${self.balance}")
        return self
        # your code here
    def yield_interest(self):
        interestrate=self.balance*self.int_rate
        if self.balance>0:
            self.balance+=interestrate
        return self
        # your code here
    @classmethod
    def print_all_accounts(cls):
        for acoount in cls.all_accounts:
            acoount.display_account_info()

class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)
    
    # other methods
    
    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self
        
    def make_withdrawl(self, amount):
        self.account.withdraw(amount)
        return self
    
    def display_user_balance(self):
        self.account.display_account_info()
        return self

    # your code here





Acc1=BankAccount(0.01,100)
Acc2=BankAccount(0.01,1000)
Acc1.deposit(200).deposit(100).deposit(300).yield_interest().display_account_info()
Acc2.deposit(100).deposit(300).withdraw(600).withdraw(600).yield_interest().display_account_info()
BankAccount.print_all_accounts()



