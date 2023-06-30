import pandas


exceldata = pandas.read_excel("../Resources/activity_19.xlsx")
print("Complete data\n")
print(exceldata)
print("---------------")
print("No. of rows are {} and columns are {}:".format(exceldata.shape[0], exceldata.shape[1]))
print("---------------")
print("Emails:\n", exceldata["Email"])
print("---------------")
print("Names in sorted order: \n", exceldata.sort_values(["First Name"]))


