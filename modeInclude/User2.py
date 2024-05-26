import json
import sys

def mergeTwoLists(l1, l2):
    # Dummy node to start the merged list
    dummy = {'val': 0, 'next': None}
    current = dummy

    # Traverse both lists and append the smaller value to the merged list
    while l1 and l2:
        if l1['val'] <= l2['val']:
            current['next'] = l1
            l1 = l1['next']
        else:
            current['next'] = l2
            l2 = l2['next']
        current = current['next']

    # If elements are left in l1 or l2, append them
    current['next'] = l1 if l1 else l2

    # Return the next of dummy since dummy is a starting node
    return dummy['next']

def list_to_linked_list(lst):
    head = None
    for val in reversed(lst):
        node = {'val': val, 'next': head}
        head = node
    return head

def linked_list_to_list(node):
    result = []
    while node:
        result.append(node['val'])
        node = node['next']
    return result

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python script.py '<json_data>'")
        sys.exit(1)

    jsonData = sys.argv[1]
    data = json.loads(jsonData)
    list1 = data['list1']
    list2 = data['list2']

    l1 = list_to_linked_list(list1)
    l2 = list_to_linked_list(list2)

    mergedList = mergeTwoLists(l1, l2)
    mergedListAsList = linked_list_to_list(mergedList)

    result = {'result': mergedListAsList}
    print(json.dumps(result))
