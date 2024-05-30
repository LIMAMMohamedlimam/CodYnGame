<?php

function lengthOfLongestSubstring($s) {
    //Write your code here
}

function main() {
    global $argv;

    if (count($argv) != 2) {
        echo "Please provide a single JSON string argument.\n";
        return;
    }

    $inputJson = $argv[1];
    $inputData = json_decode($inputJson, true);

    if (json_last_error() !== JSON_ERROR_NONE) {
        echo "Invalid JSON input.\n";
        return;
    }

    $s = isset($inputData['s']) ? $inputData['s'] : '';
    $result = lengthOfLongestSubstring($s);
    $output = ['result' => $result];

    echo json_encode($output) . "\n";
}

main();
?>
