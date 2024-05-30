#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <json-c/json.h>

void calculate_result(const char* json_input) {
    // Parse JSON input
    struct json_object *parsed_json;
    struct json_object *number1_obj;
    struct json_object *number2_obj;

    parsed_json = json_tokener_parse(json_input);

    json_object_object_get_ex(parsed_json, "number1", &number1_obj);
    json_object_object_get_ex(parsed_json, "number2", &number2_obj);

    int number1 = json_object_get_int(number1_obj);
    int number2 = json_object_get_int(number2_obj);

    // Calculate product and sum
    int product = number1 * number2;
    int result;

    if (product <= 1000) {
        result = product;
    } else {
        result = number1 + number2;
    }

    // Create JSON output
    struct json_object *result_json = json_object_new_object();
    json_object_object_add(result_json, "result", json_object_new_int(result));

    // Print the result JSON string
    printf("%s\n", json_object_to_json_string(result_json));

    // Free memory
    json_object_put(parsed_json);
    json_object_put(result_json);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s '<json_input>'\n", argv[0]);
        return 1;
    }

    const char *json_input = argv[1];
    calculate_result(json_input);

    return 0;
}
