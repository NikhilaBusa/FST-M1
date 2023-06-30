fruits = dict(apple="100",mango="150",banana="40")
fruit = input("Which fruit are you looking for? ").lower()
if fruit in fruits:
    print("Cost is: ", fruits.get(fruit))
else:
    print("Not available")
