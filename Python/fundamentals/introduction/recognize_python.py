num1 = 42# var num1 declaration
num2 = 2.3# var num declaration
boolean = True# var boolean declaration
string = 'Hello World'# var string declaration
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives']#var array declaration
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False}#dictionaries declaration
fruit = ('blueberry', 'strawberry', 'banana')#tuple declaration
print(type(fruit))#print fruit type 
print(pizza_toppings[1])#print pizza_topping elemnt 1
pizza_toppings.append('Mushrooms')#add Mushrom at the end of the array of pizza topping
print(person['name'])#print the person name from the person dictionary
person['name'] = 'George'#replace the persoon name with Georgia
person['eye_color'] = 'blue'# add eye-color: blue at the end of the dictionary
print(fruit[2])#print banana

if num1 > 45:#check if num1 is greater than 45
    print("It's greater")# if greater print It's grater
else:
    print("It's lower")#if not prnt It's lower

if len(string) < 5:# check if the string has less than 5 characters
    print("It's a short word!")# prints its a short word! if less than 5
elif len(string) > 15:
    print("It's a long word!")# if greater than 15 print it's a long word!
else:
    print("Just right!")# if notprint Just right!

for x in range(5):# for loop from 0-
    print(x)#print the loop
for x in range(2,5):# for lop from 2-4
    print(x)# print he loop
for x in range(2,10,3):#print numbers from 2 to 9 with the addtion of 3
    print(x)#print the loop
x = 0#init x to 0
while(x < 5):#when x is less than 5
    print(x)#print the value of x
    x += 1#add x +1 to x

pizza_toppings.pop()#remove the last elemt of the array
pizza_toppings.pop(1)#remove the element at the index 1

print(person)#print the dictonary
person.pop('eye_color')# remove eye color from the dictonary
print(person)#print the dictonary

for topping in pizza_toppings:#create a iteration name topping from pizza_toppings
    if topping == 'Pepperoni':#check if it is pepperoni
        continue#continue
    print('After 1st if statement')# print After 1st if statement
    if topping == 'Olives':# if topping is Olives
        break#stop the loop

def print_hello_ten_times(): # create a function
    for num in range(10): # create a for loop from 0-10 
        print('Hello')#print Hello every loop

print_hello_ten_times()#calling the function

def print_hello_x_times(x):#create a fucntion
    for num in range(x):#create a for loop with x perimeters
        print('Hello')# print Hello every loop

print_hello_x_times(4)# calling the fucntion with the perimeter 4

def print_hello_x_or_ten_times(x = 10):#create a function and the parameter x is 10
    for num in range(x):# create a loop from 0 to 9
        print('Hello')#print Hello every loop

print_hello_x_or_ten_times()#print Hello 9 times
print_hello_x_or_ten_times(4)# print Hello 4 times


"""
Bonus section
"""

# print(num3)# error message num3 not defined 
# num3 = 72#init num3 
# fruit[0] = 'cranberry'#'tuple' object does not support item assignment
# print(person['favorite_team'])#KeyError: 'favorite_team'
# print(pizza_toppings[7])#IndexError: list index out of range
#   print(boolean)#IndentationError: unexpected indent
# fruit.append('raspberry')# AttributeError: 'tuple' object has no attribute 'append'
# fruit.pop(1)#AttributeError: 'tuple' object has no attribute 'pop'