import random
import json

x = random.randint(-2**31, 2**31 - 1)

data = {"x": x}

with open("reverse_integer_input.json", "w") as json_file:
    json.dump(data, json_file)
