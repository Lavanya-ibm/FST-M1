# import pandas
import pandas

# Structure our data as a dictionary
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl23", "AllMight"]
}

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)
print(dataframe)

dataframe.to_csv("sample.csv", index=False)