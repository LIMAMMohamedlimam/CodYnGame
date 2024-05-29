import json
import random
import sys

def two_sum(nums, target):
    num_to_index = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_to_index:
            return [num_to_index[complement], i]
        num_to_index[num] = i
    return None

def generate_two_sum_case():
    length = random.randint(2, 10)
    nums = [random.randint(-100, 100) for _ in range(length)]
    idx1, idx2 = random.sample(range(length), 2)
    target = nums[idx1] + nums[idx2]
    data = {
        "nums": nums,
        "target": target
    }
    return data

def verify_two_sum_solution(json_data, result_data):
    try:
        data = json.loads(json_data)
        result = json.loads(result_data)
        nums = data['nums']
        target = data['target']
        if not isinstance(result, list) or len(result) != 2:
            return False
        indices = result
        if not (0 <= indices[0] < len(nums) and 0 <= indices[1] < len(nums)):
            return False
        return nums[indices[0]] + nums[indices[1]] == target
    except (json.JSONDecodeError, KeyError, TypeError, IndexError) as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.", file=sys.stderr)
        print("Usage: python script.py gen | verify <json_data> <result_data> | solve <json_data>", file=sys.stderr)
        sys.exit(1)

    operation = sys.argv[1]

    if operation == "gen":
        data = generate_two_sum_case()
        print(json.dumps(data))

    elif operation == "verify" and len(sys.argv) == 4:
        json_data = sys.argv[2]
        result_data = sys.argv[3]
        if verify_two_sum_solution(json_data, result_data):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")

    elif operation == "solve" and len(sys.argv) == 3:
        json_data = sys.argv[2]
        try:
            data = json.loads(json_data)
            if 'nums' not in data or 'target' not in data:
                print('{"error": "Error extracting JSON data."}', file=sys.stderr)
                sys.exit(1)

            nums = data['nums']
            target = data['target']
            result = two_sum(nums, target)

            if result is not None:
                print(json.dumps(result))
            else:
                print('{"error": "No solution found"}')

        except json.JSONDecodeError:
            print('{"error": "Error parsing JSON string."}', file=sys.stderr)
            sys.exit(1)

    else:
        print("Error: Incorrect arguments or number of arguments.", file=sys.stderr)
        print("Usage: python script.py gen | verify <json_data> <result_data> | solve <json_data>", file=sys.stderr)
        sys.exit(1)
