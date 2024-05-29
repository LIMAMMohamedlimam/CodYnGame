import sys
import json
import random

def generate_numbers():
    number1 = random.randint(1, 100)
    number2 = random.randint(1, 100)
    return number1, number2

def verifysolution(jsondata, resultdata):
    try:
        numbers = json.loads(jsondata)
        results = json.loads(resultdata)
        correct_product = numbers['number1'] * numbers['number2']
        correct_sum = numbers['number1'] + numbers['number2']
        if correct_product < 1000 :
            return results.get('result') == correct_product
        else :
            return results.get('result') == correct_sum
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        number1, number2 = generate_numbers()
        data = {"number1": number1, "number2": number2}
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
