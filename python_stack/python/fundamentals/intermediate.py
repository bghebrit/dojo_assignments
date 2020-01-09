x = [ [5,2,3], [10,8,9] ]
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]
# change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].
x[1][0] = 15
print(x)
# Change the last_name of the first student from 'Jordan' to 'Bryant'
students[0]['last_name'] = 'Bryant'
print(students)
# In the sports_directory, change 'Messi' to 'Andres'
sports_directory.update({'soccer': ['Andres', 'Ronaldo', 'Rooney']})
print(sports_directory)
# Change the value 20 in z to 30
z[0]['y'] = 30

# Create a function iterateDictionary(some_list) that, given a list of dictionaries, the function loops through each
# dictionary in the list and prints each key and the associated value. For example, given the following list
def iterateDictionary(students):
    for dictionary in students:
        for key, value in dictionary.items():
            print(key, value, end=' ' '\n')
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
iterateDictionary(students)

def keyname(student, key_name):
    for dictionary in students:
        for key, values in dictionary.items():
            if key == 'first_name':
                print(values)
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
keyname( students, key_name= None)

# 4)
def printlist(dojo):
    for key, values in dojo.items():
        for value in values:
            print(value)
dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
printlist(dojo)

# python code below!
arr = [1,3,5,7]
arr[0], arr[1] = arr[1], arr[0]
print(arr)