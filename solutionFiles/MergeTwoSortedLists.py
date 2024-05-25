import json

def merge_sorted_lists(list1, list2):
    merged_list = []
    i = 0
    j = 0

    # Parcourir les deux listes jusqu'à ce qu'une d'elles soit entièrement parcourue
    while i < len(list1) and j < len(list2):
        # Comparer les éléments des deux listes et ajouter le plus petit à la liste fusionnée
        if list1[i] < list2[j]:
            merged_list.append(list1[i])
            i += 1
        else:
            merged_list.append(list2[j])
            j += 1

    # Ajouter les éléments restants de la première liste, s'il y en a
    while i < len(list1):
        merged_list.append(list1[i])
        i += 1

    # Ajouter les éléments restants de la deuxième liste, s'il y en a
    while j < len(list2):
        merged_list.append(list2[j])
        j += 1

    return merged_list
def main(generatedData):
    l1 = generatedData["l1"]
    l2 = generatedData["l2"]
    result = merge_sorted_lists(l1, l2)
    print("la nouvelle liste triée est : {} ".format(result))

if __name__ == "__main__":
    # Si le script est exécuté en tant que programme principal
    with open("merge_two_sorted_lists_input.json") as json_file:
        generatedData = json.load(json_file)
    main(generatedData)