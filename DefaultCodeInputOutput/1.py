import sys
import json
from modeInclude import *

#def two_sum(nums, target):
    #write here your code
    

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


