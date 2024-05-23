def roman_to_integer(s):
    roman_dict = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }
    total = 0
    prev_value = 0

    for char in s:
        current_value = roman_dict[char]
        # Si la valeur précédente est inférieure à la valeur courante,
        # cela signifie que le caractère précédent était utilisé pour
        # soustraire le caractère actuel
        if prev_value < current_value:
            total += current_value - 2 * prev_value
        else:
            total += current_value
        prev_value = current_value

    return total

def main():
    # Entrée de l'utilisateur : un nombre romain
    roman_numeral = input("Entrez un nombre romain : ")

    # Appel de la fonction pour convertir le nombre romain en entier
    integer_value = roman_to_integer(roman_numeral)

    # Affichage du nombre entier correspondant
    print("La valeur entière correspondante est :", integer_value)

if __name__ == "__main__":
    main()
