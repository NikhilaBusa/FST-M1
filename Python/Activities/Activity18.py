import pandas
import csv

csvFile = pandas.read_csv("../Resources/activity_17.csv")
print(csvFile)
print("-----------")
#print("Usernames are:\n", csvFile["Usernames"])
print("Details in 2nd row:\n",csvFile["Usernames"][1],"-",csvFile["Passwords"][1])
print("-----------")
print("Username in ascending order\n",csvFile.sort_values('Usernames',ascending=True))
print("-----------")
print("Passwords in descending order\n",csvFile.sort_values('Passwords',ascending=False))