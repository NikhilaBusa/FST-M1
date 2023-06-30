import pandas

data = {"Usernames": ["admin", "Charles", "Deku"],
        "Passwords": ["password", "Charl13", "AllMight"]}

csvdata = pandas.DataFrame(data)
csvdata.to_csv("../Resources/activity_17.csv", index=False)

