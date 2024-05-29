import json
import sys

def calculate_result(json_input):
    data = json.loads(json_input)
    number1 = data["number1"]
    number2 = data["number2"]

    product = number1 * number2
    if product <= 1000:
        result = product
    else:
        result = number1 + number2

    return json.dumps({"result": result})

if __name__ == "__main__":
    # Assuming the JSON string is passed as the first argument
    json_input = sys.argv[1]
    output = calculate_result(json_input)
    print(output)
