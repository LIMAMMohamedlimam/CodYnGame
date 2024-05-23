def is_palindrome(x):
    # Les nombres négatifs ne sont pas des palindromes
    if x < 0:
        return False

    # Convertir le nombre en une chaîne de caractères
    str_x = str(x)

    # Vérifier si la chaîne est égale à son renversement
    return str_x == str_x[::-1]

def main():
    # Entrée de l'utilisateur : un nombre entier
    num = int(input("Entrez un nombre entier : "))

    # Appel de la fonction pour vérifier si le nombre est un palindrome
    if is_palindrome(num):
        print("Le nombre", num, "est un palindrome.")
    else:
        print("Le nombre", num, "n'est pas un palindrome.")

if __name__ == "__main__":
    main()
