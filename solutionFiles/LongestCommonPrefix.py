def longest_common_prefix(strs):
    if not strs:
        return ""

    # Tri des chaînes pour obtenir la plus courte en premier
    strs.sort()
    shortest = strs[0]
    longest = strs[-1]

    # Trouver le préfixe commun entre la première et la dernière chaîne
    for i in range(len(shortest)):
        if shortest[i] != longest[i]:
            return shortest[:i]

    return shortest

def main():
    # Entrée de l'utilisateur : une liste de chaînes de caractères
    strings = input("Entrez les chaînes de caractères, séparées par des espaces : ").split()

    # Appel de la fonction pour trouver le plus long préfixe commun
    common_prefix = longest_common_prefix(strings)

    # Affichage du résultat
    if common_prefix:
        print("Le plus long préfixe commun est :", common_prefix)
    else:
        print("Il n'y a pas de préfixe commun.")

if __name__ == "__main__":
    main()
