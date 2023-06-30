list1 = [1,2,5,4,74,8,30]
list2 = [2,89,92,30,37,5,29]
print("List 1: ",list1)
print("List 2: ",list2)
list3 = list()
for x in list1:
    if x%2 !=0:
        list3.append(x)
x=0
for x in list2:
    if x%2 == 0:
        list3.append(x)
print("Final list: ",list3)