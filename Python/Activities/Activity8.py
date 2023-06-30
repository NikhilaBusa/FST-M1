listOfNum = list(input("Enter comma separated values: ").split(','))
if listOfNum[0] == listOfNum[-1]:
    print("True")
else:
    print("False")