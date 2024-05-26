import random
import json

x = random.randint(0, 100000)

data = {"x": x}

print(data)
with open("palindrome_number_input.json", "w") as json_file:
    json.dump(data, json_file)
