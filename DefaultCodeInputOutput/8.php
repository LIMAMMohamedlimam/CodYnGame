<?php
function maxArea($height) {
    //Write your code here
}

if ($argc != 2) {
    echo "Usage: php script.php '<json_string>'\n";
    exit(1);
}

// Parse the JSON input
$input_json = $argv[1];
$data = json_decode($input_json, true);

if (json_last_error() !== JSON_ERROR_NONE || !isset($data['height'])) {
    echo "Invalid JSON input\n";
    exit(1);
}

$height = $data['height'];

if (!is_array($height)) {
    echo "Invalid height data\n";
    exit(1);
}

// Compute the maximum area
$result = maxArea($height);

// Convert result to JSON string with the specified format
$output_json = json_encode(["result" => $result]);

// Print the JSON string
echo $output_json . "\n";
?>
