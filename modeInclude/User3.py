import json
import subprocess

def mergeTwoLists(l1, l2):
    #your code here :
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

jsonData = sys.argv[1]
data = json.loads(jsonData)
list1 = data['list1']
list2 = data['list2']

l1 = None
for val in reversed(list1):
    node = {'val': val, 'next': l1}
    l1 = node

l2 = None
for val in reversed(list2):
    node = {'val': val, 'next': l2}
    l2 = node

mergedList = mergeTwoLists(l1, l2)

current = mergedList
while current:
    print(current['val'], end=" ")
    current = current['next']
print()
