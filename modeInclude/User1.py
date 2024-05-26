import json
import subprocess
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

# Continue with your existing code to convert list inputs into linked lists and to invoke mergeTwoLists


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
