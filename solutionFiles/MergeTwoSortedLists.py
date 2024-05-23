class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_two_lists(l1, l2):
    # Créer un nœud sentinelle pour le début de la liste fusionnée
    dummy = ListNode()
    current = dummy

    # Parcourir les deux listes et fusionner les nœuds dans l'ordre croissant
    while l1 and l2:
        if l1.val < l2.val:
            current.next = l1
            l1 = l1.next
        else:
            current.next = l2
            l2 = l2.next
        current = current.next

    # Ajouter les éléments restants s'il y en a
    if l1:
        current.next = l1
    elif l2:
        current.next = l2

    return dummy.next

def print_list(node):
    while node:
        print(node.val, end=" -> ")
        node = node.next
    print("None")

def main():
    # Création de deux listes triées
    l1 = ListNode(1)
    l1.next = ListNode(3)
    l1.next.next = ListNode(5)

    l2 = ListNode(2)
    l2.next = ListNode(4)
    l2.next.next = ListNode(6)

    # Fusionner les deux listes
    merged_list = merge_two_lists(l1, l2)

    # Afficher la liste fusionnée
    print("Liste fusionnée :")
    print_list(merged_list)

if __name__ == "__main__":
    main()
