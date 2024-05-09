import sys

def twoSum(nums: list[int], target: int) -> list[int]:
    numMap = {}
    n = len(nums)
    for i in range(n):
        complement = target - nums[i]
        if complement in numMap:
            return [numMap[complement], i]
        numMap[nums[i]] = i
    return []  # No solution found

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: python script.py [nums list] [target]")
        sys.exit(1)
    
    # Convert input arguments
    nums = list(map(int, sys.argv[1].strip('[]').split(',')))
    target = int(sys.argv[2])
    
    result = twoSum(nums, target)
    print(result)

