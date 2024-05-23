def reverse_integer(x):
    # Gérer le signe du nombre
    sign = 1 if x >= 0 else -1
    x = abs(x)

    # Inverser le nombre en utilisant des opérations sur les chiffres
    reverse = 0
    while x != 0:
        digit = x % 10
        reverse = reverse * 10 + digit
        x = x // 10

    # Gérer le débordement d'entier
    if reverse > 2**31 - 1 or reverse < -2**31:
        return 0

    return reverse * sign

def main():
    # Entrée de l'utilisateur : un nombre entier
    num = int(input("Entrez un nombre entier : "))

    # Appel de la fonction pour inverser le nombre
    reversed_num = reverse_integer(num)

    # Affichage du nombre inversé
    print("Le nombre inversé est :", reversed_num)

if __name__ == "__main__":
    main()
