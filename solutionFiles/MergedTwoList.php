<?php

function merge_two_sorted_lists($l1, $l2) {
    $merged_list = [];
    $i = $j = 0;

    // Traverse both lists and append the smaller element to the merged list
    while ($i < count($l1) && $j < count($l2)) {
        if ($l1[$i] <= $l2[$j]) {
            $merged_list[] = $l1[$i];
            $i++;
        } else {
            $merged_list[] = $l2[$j];
            $j++;
        }
    }

    // Append remaining elements, if any
    while ($i < count($l1)) {
        $merged_list[] = $l1[$i];
        $i++;
    }

    while ($j < count($l2)) {
        $merged_list[] = $l2[$j];
        $j++;
    }

    return $merged_list;
}

function main() {
    // Assuming the input is passed as the first command line argument
    global $argv;
    $input_json = $argv[1];

    // Parse the JSON input
    $data = json_decode($input_json, true);
    $l1 = isset($data['list1']) ? $data['list1'] : [];
    $l2 = isset($data['list2']) ? $data['list2'] : [];

    // Merge the two sorted lists
    $merged_list = merge_two_sorted_lists($l1, $l2);

    // Prepare the result in the desired format
    $result = ["result" => $merged_list];

    // Print the result as a JSON string
    $output_json = json_encode($result);
    echo $output_json;
}

main();

?>
