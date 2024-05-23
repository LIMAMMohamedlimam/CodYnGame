def calculate_multiplication_and_sum(a, b):
    multiplication = a * b
    addition = a + b
    return multiplication, addition

def main():
    # Demander à l'utilisateur d'entrer deux nombres
    num1 = float(input("Entrez le premier nombre : "))
    num2 = float(input("Entrez le deuxième nombre : "))

    # Calculer la multiplication et la somme des deux nombres
    result_multiplication, result_sum = calculate_multiplication_and_sum(num1, num2)

    # Afficher les résultats
    print("La multiplication de {} et {} est : {}".format(num1, num2, result_multiplication))
    print("La somme de {} et {} est : {}".format(num1, num2, result_sum))

if __name__ == "__main__":
    main()
