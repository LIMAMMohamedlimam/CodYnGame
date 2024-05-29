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

import json

def max_area(height):
    left, right = 0, len(height) - 1
    max_area = 0

    while left < right:
        width = right - left
        h = min(height[left], height[right])
        current_area = width * h
        max_area = max(max_area, current_area)

        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area

def verifysolution(jsondata, resultdata):
    try:
        # Parse the JSON input strings
        data = json.loads(jsondata)
        result = json.loads(resultdata)

        # Extract height and expected area
        height = data['height']
        expected_area = result['result']

        # Compute the area using max_area function
        computed_area = max_area(height)
        print(computed_area, " expected --> ", expected_area)

        # Return comparison result
        return computed_area == expected_area
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