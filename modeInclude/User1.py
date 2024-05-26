import json
import subprocess
import sys

def twoSum(nums, target):
   #input code here
    total = 0
    prev_value = 0
    for char in reversed(s):
        value = roman_to_int_map[char]
        if value >= prev_value:
            total += value
        else:
            total -= value
        prev_value = value
    return total

if __name__ == "__main__":
    result = sys.argv[1]
    data = json.loads(result.stdout)
    
    nums = data['nums']
    target = data['target']
    result = twoSum(nums, target)
    
    if result:
        print(result)
    else:
        print("No solution found")
