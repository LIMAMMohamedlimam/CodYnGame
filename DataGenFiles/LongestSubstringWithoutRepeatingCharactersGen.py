import random
import string
import json

def generate(length):
    return ''.join(random.choice(string.ascii_lowercase) for _ in range(length))

length = random.randint(1, 20)
s = generate(length)

data = {"s": s}
print(data)
with open("longest_substring_input.json", "w") as json_file:
    json.dump(data, json_file)
