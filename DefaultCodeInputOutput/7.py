import json
import sys

def is_valid_parentheses(s):
    #Write your code here

def main():
    # Read the JSON string from program argument
    input_json = sys.argv[1]
    input_data = json.loads(input_json)

    s = input_data['s']
    result = is_valid_parentheses(s)

    # Output the result as JSON string
    output_json = json.dumps({"result": result})
    print(output_json)

if __name__ == "__main__":
    main()





