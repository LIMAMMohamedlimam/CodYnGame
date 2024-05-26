import json
import random
import sys

def generate_two_sum_case():
    length = random.randint(2, 10)
    nums = [random.randint(-100, 100) for _ in range(length)]
    # Ensure there's a valid pair
    idx1, idx2 = random.sample(range(length), 2)
    target = nums[idx1] + nums[idx2]
    data = {
        "nums": nums,
        "target": target
    }
    return data

def find_two_sum(nums, target):
    num_to_index = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_to_index:
            return [num_to_index[complement], i]
        num_to_index[num] = i
    return []

def verify_two_sum_solution(json_data, result_data):
    try:
        data = json.loads(json_data)
        result = json.loads(result_data)
        nums = data['nums']
        target = data['target']
        indices = result

        if nums[indices[0]] + nums[indices[1]] == target:
            return True
        else:
            return False
    except Exception as e:
        print("Error:", e)
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <json_data> <result_data>")
    elif sys.argv[1] == "gen":
        data = generate_two_sum_case()
        print(json.dumps(data))
    elif sys.argv[1] == "verify" and len(sys.argv) == 4:
        json_data = sys.argv[2]
        result_data = sys.argv[3]
        if verify_two_sum_solution(json_data, result_data):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
    elif sys.argv[1] == "solve" and len(sys.argv) == 3:
        json_data = sys.argv[2]
        data = json.loads(json_data)
        nums = data['nums']
        target = data['target']
        result = find_two_sum(nums, target)
        print(json.dumps(result))
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print(sys.argv)
        print("Usage: python script.py gen OR python script.py verify <json_data> <result_data> OR python script.py solve <json_data>")
