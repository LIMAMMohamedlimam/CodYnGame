import sys
import json
import random

def generate_numbers():
    nums_length = random.randint(2, 10)
    nums = [random.randint(-1000, 1000) for _ in range(nums_length)]
    target = random.randint(-2000, 2000)
    return nums, target

def verifysolution(jsondata, resultdata):
    try:
        with open(jsondata, 'r') as f:
            data = json.load(f)
        with open(resultdata, 'r') as f:
            results = json.load(f)
        nums = data['nums']
        target = data['target']
        index1, index2 = results['indices']
        return nums[index1] + nums[index2] == target
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        nums, target = generate_numbers()
        data = {"nums": nums, "target": target}
        print(json.dumps(data))
    elif sys.argv[1] == "verify" and len(sys.argv) == 4:
        jsondata = sys.argv[2]
        resultdata = sys.argv[3]
        if verifysolution(jsondata, resultdata):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
