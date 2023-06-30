inputTuple = tuple(input("Enter values in tuple separated by commas: ").split(","))
divisibleBy5 = list()
for num in inputTuple:
    if int(num)%5 == 0:
        divisibleBy5.append(num)
if len(divisibleBy5)==0:
    print("No number is divisible by 5")
else:
    print(divisibleBy5)
