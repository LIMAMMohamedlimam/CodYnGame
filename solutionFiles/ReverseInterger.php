<?php

function reverse_integer($x) {
    // Check for the sign of the number
    $sign = $x < 0 ? -1 : 1;
    $x = abs($x);

    // Reverse the digits of the number
    $reversed_x = intval(strrev(strval($x)));

    // Restore the sign
    $reversed_x *= $sign;

    // Check if the reversed integer is within the 32-bit signed integer range
    if ($reversed_x < -pow(2, 31) || $reversed_x > pow(2, 31) - 1) {
        return 0;
    }

    return $reversed_x;
}

function main() {
    // Read the input JSON string from the program arguments
    global $argv;
    $input_json = $argv[1];

    // Parse the JSON string to get the integer
    $input_data = json_decode($input_json, true);
    $x = $input_data["x"];

    // Get the reversed integer
    $result = reverse_integer($x);

    // Prepare the output as a JSON string
    $output_json = json_encode(array("result" => $result));

    // Print the output JSON string
    echo $output_json . PHP_EOL;
}

main();
?>
