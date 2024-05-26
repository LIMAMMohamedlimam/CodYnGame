import sys
import json
import random

# Dictionary to convert Roman numeral to integer
roman_to_int_map = {
    'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000
}

def romanToInt(s):
    total = 0
    prev_value = 0
    for char in reversed(s):
        value = roman_to_int_map[char]
        if value >= prev_value:
            total += value
        else:
            total -= value
        prev_value = value
    return total

def generate_roman():
    roman_numerals = [
        ("I", 1), ("IV", 4), ("V", 5), ("IX", 9), ("X", 10),
        ("XL", 40), ("L", 50), ("XC", 90), ("C", 100),
        ("CD", 400), ("D", 500), ("CM", 900), ("M", 1000)
    ]
    
    # Generating a random Roman numeral
    roman, integer = "", 0
    while integer == 0:
        num = random.randint(1, 3999)
        integer = num
        roman = ""
        for numeral, value in reversed(roman_numerals):
            while num >= value:
                roman += numeral
                num -= value
    return roman, integer

def verify_roman_to_int(jsondata, resultdata):
    try:
        data = json.loads(jsondata)
        result = json.loads(resultdata)
        roman = data['roman']
        expected_integer = result['integer']

        calculated_integer = romanToInt(roman)
        print("calculated_integer =", calculated_integer)
        print("expected_integer =", expected_integer)

        return calculated_integer == expected_integer
    except Exception as e:
        print("Error:", e)
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        roman, integer = generate_roman()
        data = {"roman": roman}
        result = {"integer": integer}
        print("data:", json.dumps(data))
        print("result:", json.dumps(result))
    elif sys.argv[1] == "verify" and len(sys.argv) == 4:
        jsondata = sys.argv[2]
        resultdata = sys.argv[3]
        if verify_roman_to_int(jsondata, resultdata):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print(sys.argv)
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
