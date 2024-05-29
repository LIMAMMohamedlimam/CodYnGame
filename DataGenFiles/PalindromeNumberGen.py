import sys
import json
import random

def generate_number():
    return random.randint(0, 100000)

def verifysolution(jsondata, resultdata):
    try:
        data = json.loads(jsondata)
        result = json.loads(resultdata)
        x = data['x']
        expected_is_palindrome = result['result']

        is_palindrome = str(x) == str(x)[::-1]

        return is_palindrome == expected_is_palindrome
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
