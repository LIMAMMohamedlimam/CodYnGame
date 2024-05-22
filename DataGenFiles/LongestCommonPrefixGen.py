import random
import string
import json

def generate(length, prefix_length):
    prefix = ''.join(random.choice(string.ascii_lowercase) for _ in range(prefix_length))
    return [prefix + ''.join(random.choice(string.ascii_lowercase) for _ in range(length - prefix_length + 1)) for _ in range(5)]

length = random.randint(1, 10)
strs = generate(length, random.randint(1, length))

data = {"strs": strs}

with open("longest_common_prefix_input.json", "w") as json_file:
    json.dump(data, json_file)
