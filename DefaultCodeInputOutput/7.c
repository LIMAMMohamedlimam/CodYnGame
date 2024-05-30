#include <json-c/json.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to check if the input string of parentheses is valid
int is_valid_parentheses(const char *s) {
    //Write your code here
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s '<json_string>'\n", argv[0]);
        return 1;
    }

    // Parse the JSON string from the program argument
    struct json_object *parsed_json;
    struct json_object *s_json;
    parsed_json = json_tokener_parse(argv[1]);
    if (parsed_json == NULL) {
        fprintf(stderr, "Error parsing JSON input.\n");
        return 1;
    }

    // Extract the value associated with the key "s"
    if (!json_object_object_get_ex(parsed_json, "s", &s_json)) {
        fprintf(stderr, "Error extracting 's' from JSON input.\n");
        return 1;
    }
    const char *s = json_object_get_string(s_json);

    // Validate the parentheses string
    int result = is_valid_parentheses(s);

    // Output the result as a JSON string
    struct json_object *output_json = json_object_new_object();
    struct json_object *result_json = json_object_new_boolean(result);
    json_object_object_add(output_json, "result", result_json);

    printf("%s\n", json_object_to_json_string(output_json));

    // Free allocated memory
    json_object_put(parsed_json);
    json_object_put(output_json);

    return 0;
}
