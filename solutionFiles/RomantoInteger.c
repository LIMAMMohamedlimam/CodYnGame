#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int roman_to_int(const char *s) {
    int roman_to_value[256] = {0};
    roman_to_value['I'] = 1;
    roman_to_value['V'] = 5;
    roman_to_value['X'] = 10;
    roman_to_value['L'] = 50;
    roman_to_value['C'] = 100;
    roman_to_value['D'] = 500;
    roman_to_value['M'] = 1000;

    int total = 0;
    int prev_value = 0;

    for (int i = strlen(s) - 1; i >= 0; i--) {
        int value = roman_to_value[(unsigned char)s[i]];
        if (value < prev_value) {
            total -= value;
        } else {
            total += value;
        }
        prev_value = value;
    }

    return total;
}

void main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s '<json_string>'\n", argv[0]);
        return;
    }

    const char *input_json = argv[1];
    char roman_numeral[100] = {0};
    if (sscanf(input_json, "{\"roman\":\"%[^\"]\"}", roman_numeral) != 1) {
        fprintf(stderr, "{\"error\": \"Invalid JSON input\"}\n");
        return;
    }

    if (strlen(roman_numeral) == 0) {
        fprintf(stderr, "{\"error\": \"No roman numeral found\"}\n");
        return;
    }

    int integer_value = roman_to_int(roman_numeral);
    printf("{\"result\": %d}\n", integer_value);
}
