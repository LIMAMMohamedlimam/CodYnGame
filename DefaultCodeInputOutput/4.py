import json
import sys

def reverse_integer(x):
    #Write your code here

def main():
    # Read the input JSON string from the program arguments
    input_json = sys.argv[1]

    # Parse the JSON string to get the integer
    input_data = json.loads(input_json)
    x = input_data["x"]

    # Get the reversed integer
    result = reverse_integer(x)

    # Prepare the output as a JSON string
    output_json = json.dumps({"result": result})

    # Print the output JSON string
    print(output_json)

if __name__ == "__main__":
    main()
