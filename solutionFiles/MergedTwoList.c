#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <json-c/json.h>

void merge_two_sorted_lists(int* list1, int size1, int* list2, int size2, int* merged_list, int* merged_size) {
    int i = 0, j = 0, k = 0;

    // Traverse both lists and append the smaller element to the merged list
    while (i < size1 && j < size2) {
        if (list1[i] <= list2[j]) {
            merged_list[k++] = list1[i++];
        } else {
            merged_list[k++] = list2[j++];
        }
    }

    // Append remaining elements, if any
    while (i < size1) {
        merged_list[k++] = list1[i++];
    }

    while (j < size2) {
        merged_list[k++] = list2[j++];
    }

    *merged_size = k;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s '<json_string>'\n", argv[0]);
        return 1;
    }

    const char* input_json = argv[1];

    // Parse the JSON input
    struct json_object* parsed_json;
    struct json_object* list1_json;
    struct json_object* list2_json;

    parsed_json = json_tokener_parse(input_json);

    json_object_object_get_ex(parsed_json, "list1", &list1_json);
    json_object_object_get_ex(parsed_json, "list2", &list2_json);

    int size1 = json_object_array_length(list1_json);
    int size2 = json_object_array_length(list2_json);

    int* list1 = malloc(size1 * sizeof(int));
    int* list2 = malloc(size2 * sizeof(int));

    for (int i = 0; i < size1; i++) {
        list1[i] = json_object_get_int(json_object_array_get_idx(list1_json, i));
    }

    for (int i = 0; i < size2; i++) {
        list2[i] = json_object_get_int(json_object_array_get_idx(list2_json, i));
    }

    int* merged_list = malloc((size1 + size2) * sizeof(int));
    int merged_size;

    // Merge the two sorted lists
    merge_two_sorted_lists(list1, size1, list2, size2, merged_list, &merged_size);

    // Prepare the result in the desired format
    struct json_object* result_json = json_object_new_object();
    struct json_object* merged_list_json = json_object_new_array();

    for (int i = 0; i < merged_size; i++) {
        json_object_array_add(merged_list_json, json_object_new_int(merged_list[i]));
    }

    json_object_object_add(result_json, "result", merged_list_json);

    // Print the result as a JSON string
    const char* output_json = json_object_to_json_string(result_json);
    printf("%s\n", output_json);

    // Free allocated memory
    json_object_put(parsed_json);
    json_object_put(result_json);
    free(list1);
    free(list2);
    free(merged_list);

    return 0;
}
