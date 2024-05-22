import random
import json

def generate(nums_length):
    nums = [random.randint(-1000, 1000) for _ in range(nums_length)]
    target = random.randint(-2000, 2000)
    return nums, target

nums_length = random.randint(2, 10)
nums, target = generate(nums_length)

data = {"nums": nums, "target": target}
print(data)
with open("twosum_input.json", "w") as json_file:
    json.dump(data, json_file)