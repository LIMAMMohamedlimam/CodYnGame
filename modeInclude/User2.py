import sys
import json

def two_sum(nums, target):
    num_dict = {}

    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_dict:
            result = [num_dict[complement], i]
            return json.dumps(result)
        num_dict[num] = i

    return json.dumps([])  # In case no solution is found (though the problem guarantees a solution)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python script.py '{\"nums\": [...], \"target\": ...}'")
        sys.exit(1)

    input_json = sys.argv[1]
    try:
        input_data = json.loads(input_json)
        nums = input_data["nums"]
        target = input_data["target"]
        print(two_sum(nums, target))
    except (json.JSONDecodeError, KeyError):
        print("Invalid input format. Please provide a JSON string with 'nums' and 'target'.")


