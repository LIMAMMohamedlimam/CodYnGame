import sys
import json
import random

def generate_string():
    parentheses = ['(', ')', '{', '}', '[', ']']
    length = random.randint(1, 20)
    s = ''.join(random.choice(parentheses) for _ in range(length))
    return s

def verifysolution(jsondata, resultdata):
    try:
        data = json.loads(jsondata)
        result = json.loads(resultdata)
        s = data['s']
        expected_is_valid = result['is_valid']

        stack = []
        mapping = {")": "(", "}": "{", "]": "["}

        is_valid = True
        for char in s:
            if char in mapping:
                top_element = stack.pop() if stack else '#'
                if mapping[char] != top_element:
                    is_valid = False
                    break
            else:
                stack.append(char)

        is_valid = is_valid and not stack

        return is_valid == expected_is_valid
    except Exception as e:
        print("Error:", e)
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        s = generate_string()
        data = {"s": s}
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
