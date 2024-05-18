import random
import json

def generate(length):
    parentheses = ['(', ')', '{', '}', '[', ']']
    return ''.join(random.choice(parentheses) for _ in range(length))

length = random.randint(1, 20)
s = generate(length)

data = {"s": s}

with open("valid_parentheses_input.json", "w") as json_file:
    json.dump(data, json_file)
