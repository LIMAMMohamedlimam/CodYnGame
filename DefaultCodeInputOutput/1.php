<?php
function two_sum($nums, $target) {
  #write here your code
}

if ($argc != 2) {
    echo "Usage: php script.php '{\"nums\": [...], \"target\": ...}'\n";
    exit(1);
}

$input_json = $argv[1];
$input_data = json_decode($input_json, true);

if (json_last_error() !== JSON_ERROR_NONE || !isset($input_data['nums']) || !isset($input_data['target'])) {
    echo "Invalid input format. Please provide a JSON string with 'nums' and 'target'.\n";
    exit(1);
}

$nums = $input_data['nums'];
$target = $input_data['target'];
echo two_sum($nums, $target) . "\n";
?>