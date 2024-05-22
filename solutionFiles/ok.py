import sys
import random

def twoSum(nums: list[int], target: int) -> list[int]:
    numMap = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in numMap:
            return [numMap[complement], i]
        numMap[num] = i
    return []  # No solution found

def generate_random_data(size: int, min_val: int, max_val: int) -> (list[int], int):
    nums = [random.randint(min_val, max_val) for _ in range(size)]
    target = random.randint(min_val, max_val)
    return nums, target

if __name__ == "__main__":
    if len(sys.argv) == 1:
        # If no arguments are provided, generate random data
        nums, target = generate_random_data(10, 1, 100)
        print(f"Generated list: {nums}")
        print(f"Target: {target}")
    elif len(sys.argv) < 3:
        print("Usage: python script.py [nums list] [target]")
        sys.exit(1)
    else:
        try:
            # Convert input arguments
            nums = list(map(int, sys.argv[1].strip('[]').split(',')))
            target = int(sys.argv[2])
        except ValueError:
            print("Invalid input format. Make sure the list is formatted correctly and the target is an integer.")
            sys.exit(1)

    result = twoSum(nums, target)
    print(f"Indices: {result}")
