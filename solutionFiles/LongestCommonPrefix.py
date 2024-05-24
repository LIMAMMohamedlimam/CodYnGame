def longestCommonPrefix(strs):
    if not strs:
        return ""

   # Initialiser le préfixe avec la première chaîne du tableau
    prefix = strs[0]
    
    # Parcourir chaque chaîne dans le tableau à partir de la seconde
    for s in strs[1:]:
        # Réduire le préfixe jusqu'à ce qu'il soit commun avec s
        while not s.startswith(prefix):
            # Raccourcir le préfixe de un caractère à la fois
            prefix = prefix[:-1]
            # Si le préfixe est vidé, aucun préfixe commun n'existe
            if not prefix:
                return ""
    
    return prefix
