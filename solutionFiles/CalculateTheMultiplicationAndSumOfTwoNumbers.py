import json
import random

def calculate_multiplication_and_sum(a, b):
    multiplication = a * b
    addition = a + b
    return multiplication, addition

def main(generatedData):
    # Utiliser les données pour exécuter la fonction calculate_multiplication_and_sum
    num1 = generatedData["number1"]
    num2 = generatedData["number2"]
    result_multiplication, result_sum = calculate_multiplication_and_sum(num1, num2)

    # Afficher les résultats
    print("La multiplication de {} et {} est : {}".format(num1, num2, result_multiplication))
    print("La somme de {} et {} est : {}".format(num1, num2, result_sum))

if __name__ == "__main__":
    # Si le script est exécuté en tant que programme principal
    with open("product_or_sum_input.json") as json_file:
        generatedData = json.load(json_file)
    main(generatedData)
