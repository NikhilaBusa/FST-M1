listOfnum = list()
sizeoflist = int(input("Enter size of list: "))
for x in range(sizeoflist):
    listnum = int(input("Please enter the number to be in list: "))
    listOfnum.append(listnum)
print("Sum is:",sum(listOfnum))


