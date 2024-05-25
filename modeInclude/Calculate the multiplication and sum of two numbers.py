import json
import random
import os , sys

sys.path.append(os.path.join(os.path.dirname(__file__), 'DataGenFiles'))
current_file_name = os.path.basename(__file__)

from userScript import *


def generate_numbers():
    number1 = random.randint(1, 100)
    number2 = random.randint(1, 100)
    return number1, number2

def verifysolution(jsondata, resultdata):
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

def main():
    
    jsonData = generate_numbers()
    resultdata = Calculatethemultiplicationandsumoftwonumbers()
    if verifysolution(jsonData, resultdata):
            print("Solution is correct.")
    else:
            print("Solution is incorrect.")

if __name__ == "__main__":
    main()
