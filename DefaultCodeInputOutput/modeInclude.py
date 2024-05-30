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