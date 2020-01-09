""" 
# Basic - Print all integers from 0 to 150.
for i in range(151):
    print(i , end =',')

# Multiples of Five - Print all the multiples of 5 from 5 to 1000
for i in range(5, 1001):
    if i % 5 ==0:
        print(i, end=', ')

# Counting, the Dojo Way - Print integers 1 to 100. If divisible by 5, print "Coding" instead. If divisible by 10, print 'Coding dojo'.
for i in range(101):
    if i % 10 == 0:
        print('Coding Dojo')
    elif i % 5 == 0:
        print('Coding')
    else:
        print(i, end = (' , '))
# That Sucker's Huge - Add odd integers from 0 to 500,000, and print the final sum.
sum = 0
for num in range(500001):
    if num % 2 != 0:
        sum +=num
print(sum)
# Countdown by Fours - Print positive numbers starting at 2018, counting down by fours.
n = 2018
print('the numbers are:')
while n >0:
    print(n, end=(' , '))
    n-= 4 """

# Flexible Counter - Set three variables: lowNum, highNum, mult. Starting at lowNum and going through highNum, print only the integers that are a multiple of mult.
# For example, if lowNum=2, highNum=9, and mult=3, the loop should print 3, 6, 9 (on successive lines)
lowNum = 2
highNUm = 10
mult = 3
for num in range(lowNum, highNUm):
    if num % mult ==0:
        print(num)