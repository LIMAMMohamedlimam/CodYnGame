def max_area(height):
    max_area = 0
    left = 0
    right = len(height) - 1

    while left < right:
        # Calculer l'aire entre les deux hauteurs
        current_area = min(height[left], height[right]) * (right - left)
        # Mettre à jour l'aire maximale si nécessaire
        max_area = max(max_area, current_area)

        # Déplacer le pointeur de la plus petite hauteur
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area

def main():
    # Entrée de l'utilisateur : les hauteurs des conteneurs
    heights = list(map(int, input("Entrez les hauteurs des conteneurs, séparées par des espaces : ").split()))

    # Appel de la fonction pour trouver l'aire maximale
    max_water = max_area(heights)

    # Affichage du résultat
    print("La plus grande quantité d'eau pouvant être contenue est : ", max_water)

if __name__ == "__main__":
    main()
