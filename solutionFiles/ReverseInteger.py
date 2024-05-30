import json
import sys

def reverse_integer(x):
    # Check for the sign of the number
    sign = -1 if x < 0 else 1
    x *= sign

    # Reverse the digits of the number
    reversed_x = int(str(x)[::-1])

    # Restore the sign
    reversed_x *= sign

    # Check if the reversed integer is within the 32-bit signed integer range
    if reversed_x < -2**31 or reversed_x > 2**31 - 1:
        return 0

    return reversed_x

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
