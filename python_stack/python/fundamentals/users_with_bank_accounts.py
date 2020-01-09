class BankAccount:
    def __init__(self, interest, balance):
        self.interest = interest
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
    def withdraw(self, amount):
        if self.balance > amount:
            self.balance -= amount
        else:
            print('Insufficient funds: Charging a $5 fee')
            self.balance -= 5
    def display_account_info(self):
        print('Balance: $', self.balance)

    def yield_interest(self):
        self.balance *= self.interest
    def transfer(self, other_user, amount):
        self.balance -= amount
        other_user.balance += amount

class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(interest=0.02, balance=0)
    def make_deposit(self, amount):
        self.account.deposit(amount)
    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
    def display_user_balance(self):
        print(self.account.display_account_info())
    def transfer(self, other_user, amount):
        self.balance -= amount
        other_user.balance += amount
    def add_account(self, account_name, interest, balance):
        self.append({account_name: BankAccount(interest=0.2, balance=0)})

biniam = User('ben', 'ben@gmail.com')
efrem = User('efi', 'efi@gmail.com')
biniam.make_deposit(1000)
biniam.make_withdrawal(100)
biniam.transfer('efrem' , 100)
biniam.display_user_balance()