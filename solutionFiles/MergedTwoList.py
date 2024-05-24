def merge_two_sorted_lists(l1, l2):
    i, j = 0, 0  # Indices pour l1 et l2
    merged_list = []

    # Parcourir les deux listes jusqu'a ce que l'un des indices atteigne la fin de sa liste
    while i < len(l1) and j < len(l2):
        if l1[i] <= l2[j]:
            merged_list.append(l1[i])
            i += 1
        else:
            merged_list.append(l2[j])
            j += 1

    # Ajouter les elements restants de l1, si il y en a
    while i < len(l1):
        merged_list.append(l1[i])
        i += 1

    # Ajouter les elements restants de l2, si il y en a
    while j < len(l2):
        merged_list.append(l2[j])
        j += 1

    return merged_list