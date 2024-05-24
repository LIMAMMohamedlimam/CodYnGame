def romanToInt(s: str) -> int:
    roman_dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    prev_value = 0
    total = 0
    for i in s[::-1]: # reverse the string
        current_value = roman_dict[i]
        if prev_value > current_value:
            total -= current_value
        else:
            total += current_value
        prev_value = current_value
    return total