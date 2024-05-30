import sys
import json

def merge_two_sorted_lists(l1, l2):
    #write your code here 

def main():
    # Assuming the input is passed as the first command line argument
    input_json = sys.argv[1]

    # Parse the JSON input
    data = json.loads(input_json)
    l1 = data.get('list1', [])
    l2 = data.get('list2', [])

    # Merge the two sorted lists
    merged_list = merge_two_sorted_lists(l1, l2)

    # Prepare the result in the desired format
    result = {"result": merged_list}

    # Print the result as a JSON string
    output_json = json.dumps(result)
    print(output_json)

if __name__ == "__main__":
    main()
