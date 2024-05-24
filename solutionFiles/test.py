import json

def solution(number1, number2):
    # Compute the product and sum of two numbers
    product = number1 * number2
    sum_result = number1 + number2
    return {"product": product, "sum": sum_result}

if __name__ == "__main__":
    # Load JSON data from a file named 'product_or_sum_input.json'
    with open("product_or_sum_input.json", "r") as file:
        data = json.load(file)

    # Extract number1 and number2 from the loaded data
    number1 = data["number1"]
    number2 = data["number2"]

    # Call the solution function with the numbers
    result = solution(number1, number2)

    # Write the result back to a JSON file
    with open("product_or_sum_output.json", "w") as file:
        json.dump(result, file)

import json
def solution(number1, number2):
    # Compute the product and sum of two numbers

    return {"product": product, "sum": sum_result}

if __name__ == "__main__":
    # Load JSON data from a file named 'product_or_sum_input.json'
    with open("product_or_sum_input.json", "r") as file:
        data = json.load(file)

    # Extract number1 and number2 from the loaded data
    number1 = data["number1"]
    number2 = data["number2"]

    # Call the solution function with the numbers
    result = solution(number1, number2)

    # Write the result back to a JSON file
    print(json.dump(result))
