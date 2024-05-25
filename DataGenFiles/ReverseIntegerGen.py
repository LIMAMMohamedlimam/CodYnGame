import sys
import json
import random

def generate_number():
    x = random.randint(-2**31, 2**31 - 1)
    return x

def verifysolution(jsondata, resultdata):
    try:
        with open(jsondata, 'r') as f:
            data = json.load(f)
        with open(resultdata, 'r') as f:
            result = json.load(f)
        x = data['x']
        expected_reversed = result['reversed']

        sign = -1 if x < 0 else 1
        reversed_x = int(str(abs(x))[::-1]) * sign

        if reversed_x < -2**31 or reversed_x > 2**31 - 1:
            reversed_x = 0

        return reversed_x == expected_reversed
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        x = generate_number()
        data = {"x": x}
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
