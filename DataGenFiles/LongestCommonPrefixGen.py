import sys
import json
import random
import string

def generate(length, prefix_length):
    prefix = ''.join(random.choice(string.ascii_lowercase) for _ in range(prefix_length))
    return [prefix + ''.join(random.choice(string.ascii_lowercase) for _ in range(length - prefix_length)) for _ in range(5)]

def longest_common_prefix(strs):
    if not strs:
        return ""
    prefix = strs[0]
    for s in strs[1:]:
        while not s.startswith(prefix):
            prefix = prefix[:-1]
            if not prefix:
                return ""
    return prefix

def verifysolution(jsondata, resultdata):
    try:
        data = json.loads(jsondata)
        result = json.loads(resultdata)

        strs = data['strs']
        expected_prefix = result['prefix']

        return longest_common_prefix(strs) == expected_prefix
    except Exception as e:
        print("Error:", e)
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
        sys.exit(1)

    if sys.argv[1] == "gen":
        length = random.randint(1, 10)
        strs = generate(length, random.randint(1, length))
        data = {"strs": strs}
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
