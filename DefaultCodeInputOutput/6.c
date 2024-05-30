#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int roman_to_int(const char *s) {
    //Write your code here
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
