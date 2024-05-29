<?php

function calculate_result($json_input) {
    $data = json_decode($json_input, true);
    $number1 = $data["number1"];
    $number2 = $data["number2"];

    $product = $number1 * $number2;
    if ($product <= 1000) {
        $result = $product;
    } else {
        $result = $number1 + $number2;
    }

    return json_encode(["result" => $result]);
}

if ($argc > 1) {
    // Assuming the JSON string is passed as the first argument
    $json_input = $argv[1];
    $output = calculate_result($json_input);
    echo $output;
} else {
    echo json_encode(["error" => "No input provided"]);
}

?>
