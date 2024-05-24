#import random
#import json
#
#def generate_numbers():
#    number1 = random.randint(1, 100)
#    number2 = random.randint(1, 100)
#    return number1, number2
#
#number1, number2 = generate_numbers()
#
#data = {"number1": number1, "number2": number2}
#
#with open("product_or_sum_input.json", "w") as json_file:
#    json.dump(data, json_file)



import sys
import json
import random

def generate_numbers():
    number1 = random.randint(1, 100)
    number2 = random.randint(1, 100)
    return number1, number2

def verifysolution(jsondata, resultdata):
    # Example implementation of verification logic
    try:
        with open(jsondata, 'r') as f:
            numbers = json.load(f)
        with open(resultdata, 'r') as f:
            results = json.load(f)
        correct_product = numbers['number1'] * numbers['number2']
        correct_sum = numbers['number1'] + numbers['number2']
        return results.get('product') == correct_product and results.get('sum') == correct_sum
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verif <jsondata> <resultdata>")
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
        print("Usage: python script.py gen OR python script.py verif <jsondata> <resultdata>")
