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
            return -1
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

    def transfer_money(self, amount, other_account):
        x=self.make_withdrawl(amount)
        if x !=-1:
            other_account.balance+=amount
        else:
            print("Not enough money")
        return self


    
    

user1=User("Sadie", "hanminsoe10@gmail.com")
user2=User("Phone", "hanminsoe10@gmail.com")
# user2.account=Acc3
Acc1=BankAccount(0.01,100)
Acc2=BankAccount(0.01,1000)
Acc3=BankAccount(0.01,5000)



def which_account(accounts):
    # user2=User("Phone", "hanminsoe10@gmail.com")
    # user2.make_deposit(1000).make_withdrawl(450).display_user_balance()
    user1.account=accounts
    user1.make_deposit(100).make_deposit(100).make_withdrawl(50).make_deposit(100).transfer_money(200, Acc3).display_user_balance()

which_account(Acc2)#pick Acc1 or Acc2

# .transger_money(200,Acc3)
# print(Acc3.balance+300)

