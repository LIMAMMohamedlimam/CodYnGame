<?php

function longestCommonPrefix($strs) {
    //Write your code here
}

if ($argc < 2) {
    echo json_encode(["error" => "No input provided"]);
    exit(1);
}

$inputStr = $argv[1];
$data = json_decode($inputStr, true);

if (json_last_error() !== JSON_ERROR_NONE || !isset($data['strs']) || !is_array($data['strs'])) {
    echo json_encode(["error" => "Invalid input"]);
    exit(1);
}

$strs = $data['strs'];
if (array_filter($strs, 'is_string') !== $strs) {
    echo json_encode(["error" => "Invalid input"]);
    exit(1);
}

$result = longestCommonPrefix($strs);
echo json_encode(["longest_common_prefix" => $result]);

?>
