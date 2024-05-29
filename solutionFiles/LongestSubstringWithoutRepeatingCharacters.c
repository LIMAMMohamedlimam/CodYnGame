#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Function to find the length of the longest substring without repeating characters
int length_of_longest_substring(const char *s) {
    int n = strlen(s);
    int max_length = 0;
    int left = 0;
    int index[128] = {0}; // Assuming ASCII characters

    for (int right = 0; right < n; ++right) {
        left = index[(int)s[right]] > left ? index[(int)s[right]] : left;
        max_length = (max_length > (right - left + 1)) ? max_length : (right - left + 1);
        index[(int)s[right]] = right + 1;
    }

    return max_length;
}

// Function to extract the value of "s" from JSON string input
char* extract_value_from_json(const char *json, const char *key) {
    const char *start = strstr(json, key);
    if (!start) return NULL;

    start = strchr(start, ':');
    if (!start) return NULL;

    start = strchr(start, '\"');
    if (!start) return NULL;

    ++start; // Move past the initial quote
    const char *end = strchr(start, '\"');
    if (!end) return NULL;

    size_t len = end - start;
    char *value = (char*)malloc(len + 1);
    if (!value) return NULL;

    strncpy(value, start, len);
    value[len] = '\0';

    return value;
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Please provide a single JSON string argument.\n");
        return 1;
    }

    char *input_json = argv[1];
    char *s = extract_value_from_json(input_json, "\"s\"");
    if (!s) {
        fprintf(stderr, "Invalid JSON input.\n");
        return 1;
    }

    int result = length_of_longest_substring(s);
    free(s);

    printf("{\"result\": %d}\n", result);

    return 0;
}
