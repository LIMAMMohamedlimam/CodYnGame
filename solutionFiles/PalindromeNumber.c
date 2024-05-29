#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <json-c/json.h>

// Function to check if a number is a palindrome
bool is_palindrome(int x) {
    char str[20];
    snprintf(str, sizeof(str), "%d", x);
    int len = strlen(str);

    for (int i = 0; i < len / 2; ++i) {
        if (str[i] != str[len - i - 1]) {
            return false;
        }
    }
    return true;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("{\"error\": \"Invalid input\"}\n");
        return 1;
    }

    const char *input_json = argv[1];
    struct json_object *parsed_json;
    struct json_object *x_value;

    parsed_json = json_tokener_parse(input_json);
    if (parsed_json == NULL) {
        printf("{\"error\": \"Invalid JSON\"}\n");
        return 1;
    }

    if (!json_object_object_get_ex(parsed_json, "x", &x_value) || !json_object_is_type(x_value, json_type_int)) {
        printf("{\"error\": \"Value is not an integer\"}\n");
        json_object_put(parsed_json); // Free memory
        return 1;
    }

    int x = json_object_get_int(x_value);
    bool result = is_palindrome(x);

    printf("{\"result\": %s}\n", result ? "true" : "false");

    json_object_put(parsed_json); // Free memory
    return 0;
}
