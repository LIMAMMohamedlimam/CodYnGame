<?php
function maxArea($height) {
    $left = 0;
    $right = count($height) - 1;
    $max_area = 0;

    while ($left < $right) {
        $width = $right - $left;
        $h = min($height[$left], $height[$right]);
        $current_area = $width * $h;
        $max_area = max($max_area, $current_area);

        if ($height[$left] < $height[$right]) {
            $left++;
        } else {
            $right--;
        }
    }

    return $max_area;
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
