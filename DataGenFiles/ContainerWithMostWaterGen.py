import json
import sys
import random

def generate_lists():
    length1 = random.randint(0, 10)
    length2 = random.randint(0, 10)
    list1 = sorted([random.randint(-100, 100) for _ in range(length1)])
    list2 = sorted([random.randint(-100, 100) for _ in range(length2)])
    return list1, list2

def generate_heights():
    length = random.randint(0, 10)
    heights = [random.randint(0, 100) for _ in range(length)]
    return heights

def mergeTwoLists(l1, l2):
    dummy = {'val': 0, 'next': None}
    current = dummy

    while l1 and l2:
        if l1['val'] <= l2['val']:
            current['next'] = l1
            l1 = l1['next']
        else:
            current['next'] = l2
            l2 = l2['next']
        current = current['next']

    current['next'] = l1 if l1 else l2
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

def maxArea(height):
    max_area = 0
    left, right = 0, len(height) - 1

    while left < right:
        width = right - left
        max_area = max(max_area, min(height[left], height[right]) * width)
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area

def handle_merge_two_sorted_lists(jsonData):
    data = json.loads(jsonData)
    list1 = data['list1']
    list2 = data['list2']

    l1 = list_to_linked_list(list1)
    l2 = list_to_linked_list(list2)

    mergedList = mergeTwoLists(l1, l2)
    mergedListAsList = linked_list_to_list(mergedList)

    result = {'result': mergedListAsList}
    print(json.dumps(result))

def handle_container_with_most_water(jsonData):
    data = json.loads(jsonData)
    height = data['height']

    max_area = maxArea(height)
    result = {'result': max_area}
    print(json.dumps(result))

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen <problem> OR python script.py solve <problem> <jsondata>")
        sys.exit(1)

    operation = sys.argv[1]
    problem = sys.argv[2]

    if operation == "gen":
        if problem == "merge_two_sorted_lists":
            list1, list2 = generate_lists()
            data = {"list1": list1, "list2": list2}
            print(json.dumps(data))
        elif problem == "container_with_most_water":
            heights = generate_heights()
            data = {"height": heights}
            print(json.dumps(data))
        else:
            print("Error: Unknown problem type.")
            sys.exit(1)
    elif operation == "solve" and len(sys.argv) == 4:
        jsonData = sys.argv[3]
        if problem == "merge_two_sorted_lists":
            handle_merge_two_sorted_lists(jsonData)
        elif problem == "container_with_most_water":
            handle_container_with_most_water(jsonData)
        else:
            print("Error: Unknown problem type.")
            sys.exit(1)
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print("Usage: python script.py gen <problem> OR python script.py solve <problem> <jsondata>")
        sys.exit(1)
