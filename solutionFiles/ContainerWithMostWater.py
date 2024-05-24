


def maxArea(height):
    max_area = 0
    left = 0
    right = len(height) - 1

    while left < right:
        # Hauteur minimale entre les deux pointeurs
        min_height = min(height[left], height[right])
        # Calculer l'aire actuelle
        current_area = min_height * (right - left)
        # Mise à jour de l'aire maximale, si nécessaire
        max_area = max(max_area, current_area)

        # Déplacer le pointeur qui pointe vers la barre la plus basse
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area
