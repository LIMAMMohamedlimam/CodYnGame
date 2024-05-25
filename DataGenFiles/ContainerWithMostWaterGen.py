import sys
import json
import random


def generate_heights():
    height = [random.randint(1, 100) for _ in range(random.randint(2, 20))]
    return height

def max_area(height):
    max_water = 0
    left, right = 0, len(height) - 1

    while left < right:
        width = right - left
        current_height = min(height[left], height[right])
        max_water = max(max_water, width * current_height)

        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_water

def verifysolution(jsondata, resultdata):
    try:
        with open(jsondata, 'r') as f:
            data = json.load(f)
        with open(resultdata, 'r') as f:
            result = json.load(f)

        height = data['height']
        expected_area = result['area']

        return max_area(height) == expected_area
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        height = generate_heights()
        data = {"height": height}
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
