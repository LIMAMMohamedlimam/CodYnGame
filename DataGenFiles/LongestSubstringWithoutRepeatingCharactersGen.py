import sys
import json
import random
import string

def generate_string(length=10):
    return ''.join(random.choice(string.ascii_letters) for _ in range(length))

def length_of_longest_substring(s):
    n = len(s)
    char_index = {}
    max_length = 0
    start = 0

    for end in range(n):
        if s[end] in char_index:
            start = max(start, char_index[s[end]] + 1)
        char_index[s[end]] = end
        max_length = max(max_length, end - start + 1)

    return max_length

def verifysolution(jsondata, resultdata):
    try:
        data = json.loads(jsondata)
        result = json.loads(resultdata)
        s = data['s']
        expected_length = result['result']

        calculated_length = length_of_longest_substring(s)
        print("calculated_length =", calculated_length)
        print("expected_length =", expected_length)

        return calculated_length == expected_length
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
        print(sys.argv)
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
