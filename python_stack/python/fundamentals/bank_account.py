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
rita = BankAccount(2.2, 15)
bini = BankAccount(.2, 100)
rita.deposit(250)
rita.yield_interest()
rita.withdraw(50)
bini.transfer(rita, 100)
rita.display_account_info()
bini.display_account_info()
