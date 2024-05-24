def is_palindrome(x):
    # Convertir le nombre en chaîne de caractères
    s = str(x)
    
    # Initialiser les indices pour pointer au début et à la fin de la chaîne
    i, j = 0, len(s) - 1
    
    # Vérifier les caractères un à un de l'avant vers le centre et de l'arrière vers le centre
    while i < j:
        if s[i] != s[j]:
            return False
        i += 1
        j -= 1
    
    return True