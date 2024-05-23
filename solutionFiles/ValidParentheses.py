def is_valid(s):
    stack = []
    # Dictionnaire pour stocker les correspondances entre parenthèses
    parentheses_map = {')': '(', ']': '[', '}': '{'}

    for char in s:
        if char in parentheses_map.values():
            # Si c'est une parenthèse ouvrante, ajoutez-la à la pile
            stack.append(char)
        elif char in parentheses_map.keys():
            # Si c'est une parenthèse fermante
            if not stack or parentheses_map[char] != stack.pop():
                return False
        else:
            # Ignorer les caractères qui ne sont pas des parenthèses
            continue

    # La chaîne est valide si la pile est vide à la fin
    return not stack

def main():
    # Entrée de l'utilisateur : une chaîne de parenthèses
    parentheses_string = input("Entrez une chaîne de parenthèses : ")

    # Appel de la fonction pour vérifier si la chaîne est valide
    if is_valid(parentheses_string):
        print("La chaîne de parenthèses est valide.")
    else:
        print("La chaîne de parenthèses n'est pas valide.")

if __name__ == "__main__":
    main()
