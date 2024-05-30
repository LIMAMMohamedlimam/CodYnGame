#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <json-c/json.h>

int reverse_integer(int x) {
    //Write your code here
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <json_string>\n", argv[0]);
        return 1;
    }

    const char *input_json = argv[1];

    struct json_object *parsed_json;
    struct json_object *x_obj;

    parsed_json = json_tokener_parse(input_json);
    if (parsed_json == NULL) {
        fprintf(stderr, "Invalid JSON input\n");
        return 1;
    }

    if (!json_object_object_get_ex(parsed_json, "x", &x_obj)) {
        fprintf(stderr, "JSON does not contain 'x' field\n");
        json_object_put(parsed_json); // Free memory
        return 1;
    }

    int x = json_object_get_int(x_obj);

    int result = reverse_integer(x);

    struct json_object *result_json = json_object_new_object();
    json_object_object_add(result_json, "result", json_object_new_int(result));

    const char *output_json = json_object_to_json_string(result_json);
    printf("%s\n", output_json);

    // Free memory
    json_object_put(parsed_json);
    json_object_put(result_json);

    return 0;
}
