import json
import sys

def reverse(x):
    # Determine the sign of x
    sign = -1 if x < 0 else 1
    # Reverse the digits of the absolute value of x
    reversed_str = str(abs(x))[::-1]
    reversed_int = int(reversed_str)
    # Reapply the sign
    reversed_int *= sign
    # Handle 32-bit integer overflow
    if reversed_int < -2**31 or reversed_int > 2**31 - 1:
        return 0
    return reversed_int

if len(sys.argv) != 2:
    print(f"Usage: {sys.argv[0]} '<json_string>'", file=sys.stderr)
    sys.exit(1)

json_string = sys.argv[1]
try:
    parsed_json = json.loads(json_string)
except json.JSONDecodeError:
    print("Error parsing JSON string.", file=sys.stderr)
    sys.exit(1)

if 'x' not in parsed_json:
    print("Error extracting JSON data.", file=sys.stderr)
    sys.exit(1)

x = parsed_json['x']
result = reverse(x)
print(f"Reversed integer: {result}")
