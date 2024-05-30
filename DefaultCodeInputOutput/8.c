#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <json-c/json.h>

int max_area(int *height, int heightSize) {
    //Write your code here
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s '<json_string>'\n", argv[0]);
        return 1;
    }

    // Parse the JSON input
    const char *input_json = argv[1];
    struct json_object *parsed_json;
    struct json_object *height_json;

    parsed_json = json_tokener_parse(input_json);
    if (!parsed_json) {
        fprintf(stderr, "Invalid JSON input\n");
        return 1;
    }

    if (!json_object_object_get_ex(parsed_json, "height", &height_json)) {
        fprintf(stderr, "JSON does not contain 'height'\n");
        json_object_put(parsed_json);
        return 1;
    }

    const char *height_str = json_object_get_string(height_json);
    struct json_object *height_array = json_tokener_parse(height_str);
    if (!height_array || !json_object_is_type(height_array, json_type_array)) {
        fprintf(stderr, "Invalid height array\n");
        json_object_put(parsed_json);
        json_object_put(height_array);
        return 1;
    }

    int heightSize = json_object_array_length(height_array);
    int *height = malloc(heightSize * sizeof(int));
    if (!height) {
        fprintf(stderr, "Memory allocation error\n");
        json_object_put(parsed_json);
        json_object_put(height_array);
        return 1;
    }

    for (int i = 0; i < heightSize; i++) {
        struct json_object *height_element = json_object_array_get_idx(height_array, i);
        height[i] = json_object_get_int(height_element);
    }

    // Compute the maximum area
    int result = max_area(height, heightSize);

    // Output result as JSON
    struct json_object *result_json = json_object_new_object();
    struct json_object *result_value = json_object_new_int(result);
    json_object_object_add(result_json, "result", result_value);

    printf("%s\n", json_object_to_json_string(result_json));

    // Clean up
    free(height);
    json_object_put(parsed_json);
    json_object_put(height_array);
    json_object_put(result_json);

    return 0;
}
