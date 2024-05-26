import random
import json

symbols = ['I', 'V', 'X', 'L', 'C', 'D', 'M']

s = ''.join(random.choices(symbols, k=random.randint(1, 15)))

data = {"s": s}


print(data)
with open("roman_to_integer_input.json", "w") as json_file:
    json.dump(data, json_file)
