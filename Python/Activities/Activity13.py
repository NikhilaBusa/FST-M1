def listsum(inputList):
    reqsum = 0
    for i in inputList:
        reqsum += i
    return reqsum


lisofNum = [1, 5, 6, 8, 9]
print("Sum is :", listsum(lisofNum))
