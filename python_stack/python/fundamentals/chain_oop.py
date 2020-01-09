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
    def display_user_balance(self,name):
        print(self.account_balance)
        print(self.name)
        # return self
    def  transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
bini = User('binyam', 'sghebrit@gmail')
rita = User('rita', 'rita@gmail.com')
guido = User('guido', 'guido@gmail.com')
guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50).display_user_balance(guido)




