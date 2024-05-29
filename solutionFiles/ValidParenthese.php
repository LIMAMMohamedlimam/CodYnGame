<?php

function is_valid_parentheses($s) {
    $stack = [];
    $mapping = [')' => '(', '}' => '{', ']' => '['];

    for ($i = 0; $i < strlen($s); $i++) {
        $char = $s[$i];

        if (in_array($char, $mapping)) {
            array_push($stack, $char);
        } elseif (array_key_exists($char, $mapping)) {
            if (!empty($stack) && end($stack) == $mapping[$char]) {
                array_pop($stack);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    return empty($stack);
}

function main($argv) {
    if (count($argv) < 2) {
        echo json_encode(["error" => "No input provided"]);
        return;
    }

    // Read the JSON string from program argument
    $input_json = $argv[1];
    $input_data = json_decode($input_json, true);

    if (json_last_error() !== JSON_ERROR_NONE) {
        echo json_encode(["error" => "Invalid JSON"]);
        return;
    }

    if (!isset($input_data['s'])) {
        echo json_encode(["error" => "'s' key not found in JSON"]);
        return;
    }

    $s = $input_data['s'];
    $result = is_valid_parentheses($s);

    // Output the result as JSON string
    $output_json = json_encode(["result" => $result]);
    echo $output_json;
}

if ($argc > 1) {
    main($argv);
} else {
    echo json_encode(["error" => "No input provided"]);
}

?>
