import random
import json

def generate_list(length):
    return sorted([random.randint(-100, 100) for _ in range(length)])

length1 = random.randint(0, 10)
length2 = random.randint(0, 10)
l1 = generate_list(length1)
l2 = generate_list(length2)

data = {"l1": l1, "l2": l2}
print(data)
with open("merge_two_sorted_lists_input.json", "w") as json_file:
    json.dump(data, json_file)
