import json
import random
import sys

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

def generate_lists():
    length1 = random.randint(0, 10)
    length2 = random.randint(0, 10)
    list1 = sorted([random.randint(-100, 100) for _ in range(length1)])
    list2 = sorted([random.randint(-100, 100) for _ in range(length2)])
    return list1, list2

def is_palindrome(x):
    s = str(x)
    return s == s[::-1]

def generate_number():
    return random.randint(-10000, 10000)

def main():
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen_merge | gen_palindrome | verify_merge <jsondata> <resultdata> | verify_palindrome <number>")
        sys.exit(1)

    operation = sys.argv[1]

    if operation == "gen_merge":
        list1, list2 = generate_lists()
        data = {"list1": list1, "list2": list2}
        print(json.dumps(data))

    elif operation == "verify_merge" and len(sys.argv) == 4:
        jsondata = sys.argv[2]
        resultdata = sys.argv[3]
        data = json.loads(jsondata)
        result = json.loads(resultdata)
        list1 = data['list1']
        list2 = data['list2']
        expected_merged = result

        l1 = list_to_linked_list(list1)
        l2 = list_to_linked_list(list2)

        mergedList = mergeTwoLists(l1, l2)
        mergedListAsList = linked_list_to_list(mergedList)

        if mergedListAsList == expected_merged:
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
        sys.exit(0)

    elif operation == "gen_palindrome":
        number = generate_number()
        data = {"number": number}
        print(json.dumps(data))

    elif operation == "verify_palindrome" and len(sys.argv) == 3:
        number = int(sys.argv[2])
        result = is_palindrome(number)
        print(json.dumps({"result": result}))

    else:
        print("Error: Incorrect arguments or number of arguments.")
        print("Usage: python script.py gen_merge | gen_palindrome | verify_merge <jsondata> <resultdata> | verify_palindrome <number>")
        sys.exit(1)

if __name__ == "__main__":
    main()
