import random
import json

def generate_numbers():
    number1 = random.randint(1, 100)
    number2 = random.randint(1, 100)
    return number1, number2

number1, number2 = generate_numbers()

data = {"number1": number1, "number2": number2}

with open("product_or_sum_input.json", "w") as json_file:
    json.dump(data, json_file)
