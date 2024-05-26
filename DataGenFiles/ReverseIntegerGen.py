import json
import random
import sys

def reverse_integer(x):
    sign = -1 if x < 0 else 1
    x = abs(x)
    reversed_x = 0

    while x != 0:
        reversed_x = reversed_x * 10 + x % 10
        x //= 10

    reversed_x *= sign

    # 32-bit signed integer range: -2^31 to 2^31 - 1
    if reversed_x < -2**31 or reversed_x > 2**31 - 1:
        return 0

    return reversed_x

def generate_integer():
    x = random.randint(-2**31, 2**31 - 1)
    return {"x": x}

def verify_solution(json_data, result_data):
    try:
        data = json.loads(json_data)
        result = json.loads(result_data)
        x = data['x']
        expected_reversed = result['result']

        actual_reversed = reverse_integer(x)
        print("actual_reversed =", actual_reversed)
        print("expected_reversed =", expected_reversed)

        return actual_reversed == expected_reversed
    except Exception as e:
        print("Error:", e)
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <json_data> <result_data>")
        sys.exit(1)

    if sys.argv[1] == "gen":
        data = generate_integer()
        print(json.dumps(data))
    elif sys.argv[1] == "verify" and len(sys.argv) == 4:
        json_data = sys.argv[2]
        result_data = sys.argv[3]
        if verify_solution(json_data, result_data):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print("Usage: python script.py gen OR python script.py verify <json_data> <result_data>")
        sys.exit(1)
