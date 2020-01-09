class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    def make_deposit(self, amount):
        self.account_balance += amount
        return self
    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self
    def display_user_balance(self):
        print(self.account_balance)
        # return self
    def  transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
bini = User('bini' , 'sghebrit@gmail.com')
rita = User('rita' , 'rita@gmail.com')
guido = User('guido' , 'gudio@gmail.com')

bini.make_deposit(100)
bini.make_deposit(300)
bini.make_deposit(400)
bini.make_withdrawal(250)
bini.display_user_balance()

