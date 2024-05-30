#include <stdio.h>
#include "modeInclude.h"
#include <stdlib.h>
#include <string.h>
#include <json-c/json.h>

void two_sum(int* nums, int numsSize, int target) {
    //write here your code

}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s '{\"nums\": [...], \"target\": ...}'\n", argv[0]);
        return 1;
    }

    const char* input_json = argv[1];
    struct json_object* parsed_json;
    struct json_object* nums_json;
    struct json_object* target_json;

    parsed_json = json_tokener_parse(input_json);
    if (parsed_json == NULL) {
        fprintf(stderr, "Invalid JSON format.\n");
        return 1;
    }

    if (!json_object_object_get_ex(parsed_json, "nums", &nums_json) ||
        !json_object_object_get_ex(parsed_json, "target", &target_json)) {
        fprintf(stderr, "JSON must contain 'nums' and 'target'.\n");
        return 1;
    }

    int nums_size = json_object_array_length(nums_json);
    int* nums = (int*)malloc(nums_size * sizeof(int));
    for (int i = 0; i < nums_size; i++) {
        nums[i] = json_object_get_int(json_object_array_get_idx(nums_json, i));
    }
    int target = json_object_get_int(target_json);

    two_sum(nums, nums_size, target);

    free(nums);
    json_object_put(parsed_json);

    return 0;
}
