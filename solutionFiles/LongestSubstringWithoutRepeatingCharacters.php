<?php

function lengthOfLongestSubstring($s) {
    $charSet = [];
    $left = 0;
    $maxLength = 0;

    for ($right = 0; $right < strlen($s); $right++) {
        while (in_array($s[$right], $charSet)) {
            unset($charSet[array_search($s[$left], $charSet)]);
            $left++;
        }
        $charSet[] = $s[$right];
        $maxLength = max($maxLength, $right - $left + 1);
    }

    return $maxLength;
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
