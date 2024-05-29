<?php
function romanToInt($s) {
    $roman_to_value = array(
        'I' => 1, 'V' => 5, 'X' => 10, 'L' => 50, 'C' => 100, 'D' => 500, 'M' => 1000
    );
    $total = 0;
    $prev_value = 0;

    $chars = str_split(strrev($s)); // Reverse and split string into array
    foreach ($chars as $char) {
        $value = $roman_to_value[$char];
        if ($value < $prev_value) {
            $total -= $value;
        } else {
            $total += $value;
        }
        $prev_value = $value;
    }

    return $total;
}

function main() {
    global $argv;

    if (count($argv) != 2) {
        echo json_encode(array("error" => "Usage: php script.php '<json_string>'"));
        return;
    }

    $input_json = $argv[1];
    $data = json_decode($input_json, true);

    if (json_last_error() !== JSON_ERROR_NONE) {
        echo json_encode(array("error" => "Invalid JSON input"));
        return;
    }

    if (!isset($data['roman']) || empty($data['roman'])) {
        echo json_encode(array("error" => "No roman numeral found"));
        return;
    }

    $roman_numeral = $data['roman'];
    $integer_value = romanToInt($roman_numeral);
    $result = array("result" => $integer_value);
    echo json_encode($result);
}

main();
?>
