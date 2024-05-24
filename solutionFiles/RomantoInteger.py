def romanToInt(s: str) -> int:
    # Dictionnaire des valeurs des chiffres romains
    roman_dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    
    # Initialisation de la valeur précédente à 0 pour commencer les comparaisons
    prev_value = 0
    
    # Initialisation du total à 0 pour accumuler le résultat
    total = 0
    
    # Parcourir la chaîne de caractères en ordre inversé
    for i in s[::-1]:  # La chaîne est inversée pour faciliter le traitement des soustractions
        # Récupération de la valeur courante du caractère
        current_value = roman_dict[i]
        
        # Si la valeur précédente est supérieure à la valeur courante, cela signifie une soustraction
        if prev_value > current_value:
            total -= current_value
        else:
            # Sinon, ajouter normalement la valeur courante au total
            total += current_value
        
        # Mise à jour de la valeur précédente pour le prochain tour de boucle
        prev_value = current_value
    
    # Retourner la valeur totale convertie
    return total
