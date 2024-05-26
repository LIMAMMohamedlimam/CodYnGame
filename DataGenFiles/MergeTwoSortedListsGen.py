import sys
import json
import random

def generate_lists():
    length1 = random.randint(0, 10)
    length2 = random.randint(0, 10)
    list1 = sorted([random.randint(-100, 100) for _ in range(length1)])
    list2 = sorted([random.randint(-100, 100) for _ in range(length2)])
    return list1, list2

def verifysolution(jsondata, resultdata):
    try:
        with open(jsondata, 'r') as f:
            data = json.load(f)
        with open(resultdata, 'r') as f:
            result = json.load(f)
        list1 = data['list1']
        list2 = data['list2']
        expected_merged = result['merged']

        merged = sorted(list1 + list2)
        print("merged =" , merged)
        print("expected_merged =" , expected_merged)

        return merged == expected_merged
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        list1, list2 = generate_lists()
        data = {"list1": list1, "list2": list2}
        print(json.dumps(data))
    elif sys.argv[1] == "verify" and len(sys.argv) == 4:
        jsondata = sys.argv[2]
        resultdata = sys.argv[3]
        if verifysolution(jsondata, resultdata):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print(sys.argv)
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
