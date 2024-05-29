<?php

function is_palindrome($x) {
    $str_x = strval($x);
    return $str_x === strrev($str_x);
}

function main() {
    global $argv;

    if (count($argv) != 2) {
        echo json_encode(["error" => "Invalid input"]);
        return;
    }

    $input_json = $argv[1];

    $data = json_decode($input_json, true);
    if (json_last_error() !== JSON_ERROR_NONE) {
        echo json_encode(["error" => "Invalid JSON"]);
        return;
    }

    if (!isset($data['x'])) {
        echo json_encode(["error" => "Missing key 'x'"]);
        return;
    }

    $x = $data['x'];
    if (!is_int($x)) {
        echo json_encode(["error" => "Value is not an integer"]);
        return;
    }

    $result = is_palindrome($x);
    echo json_encode(["result" => $result]);
}

main();

?>
