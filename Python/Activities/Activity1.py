import datetime

name = input("Enter your name:")
age = int(input("Enter your age:"))
if age<100:
    out=datetime.datetime.now().year+(100-age)
    print("{}, you will turn 100 in year".format(name),out)
else:
    print("You are already {} years old!".format(age))

