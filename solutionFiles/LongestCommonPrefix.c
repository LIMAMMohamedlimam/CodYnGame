#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <json-c/json.h>

char* longest_common_prefix(char** strs, int strsSize) {
    if (strsSize == 0) return "";

    char* prefix = strdup(strs[0]);
    for (int i = 1; i < strsSize; i++) {
        while (strncmp(strs[i], prefix, strlen(prefix)) != 0) {
            prefix[strlen(prefix) - 1] = '\0';
            if (strlen(prefix) == 0) return "";
        }
    }
    return prefix;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        printf("{\"error\": \"No input provided\"}\n");
        return 1;
    }

    struct json_object *parsed_json;
    struct json_object *strs_array;
    struct json_object *str;
    size_t n_strs;
    size_t i;

    parsed_json = json_tokener_parse(argv[1]);
    if (!parsed_json) {
        printf("{\"error\": \"Invalid input\"}\n");
        return 1;
    }

    if (!json_object_object_get_ex(parsed_json, "strs", &strs_array)) {
        printf("{\"error\": \"Invalid input\"}\n");
        json_object_put(parsed_json);
        return 1;
    }

    n_strs = json_object_array_length(strs_array);
    char* strs[n_strs];
    for (i = 0; i < n_strs; i++) {
        str = json_object_array_get_idx(strs_array, i);
        strs[i] = strdup(json_object_get_string(str));
    }

    char* result = longest_common_prefix(strs, n_strs);
    printf("{\"longest_common_prefix\": \"%s\"}\n", result);

    // Free allocated memory
    for (i = 0; i < n_strs; i++) {
        free(strs[i]);
    }
    free(result);
    json_object_put(parsed_json);

    return 0;
}
