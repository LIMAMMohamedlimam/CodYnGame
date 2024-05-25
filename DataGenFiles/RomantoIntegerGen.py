import sys
import json
import random

def generate_string():
    symbols = ['I', 'V', 'X', 'L', 'C', 'D', 'M']
    s = ''.join(random.choices(symbols, k=random.randint(1, 15)))
    return s

def verifysolution(jsondata, resultdata):
    try:
        with open(jsondata, 'r') as f:
            data = json.load(f)
        with open(resultdata, 'r') as f:
            result = json.load(f)
        s = data['s']
        expected_integer = result['integer']

        roman_to_int = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        int_val = 0
        prev_value = 0
        for char in reversed(s):
            value = roman_to_int[char]
            if value < prev_value:
                int_val -= value
            else:
                int_val += value
            prev_value = value

        return int_val == expected_integer
    except Exception as e:
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
