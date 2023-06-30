import pandas
from pandas import ExcelWriter
from pandas import ExcelFile


data = {"First Name": ["Satvik", "Avinash", "Lahri"],
        "Last Name": ["Shah", "Kati", "Rath"],
        "Email": ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
        "PhoneNumber": ["4537829158", "5892184058", "4528727830"]}
exceldata = pandas.DataFrame(data)
writer = ExcelWriter("../Resources/activity_19.xlsx")
exceldata.to_excel(writer,"19Sheet",index=False)
writer.close()
