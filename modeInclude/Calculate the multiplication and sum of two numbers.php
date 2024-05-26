<?php
function generateNumbers() {
    $number1 = rand(1, 100);
    $number2 = rand(1, 100);
    return array('number1' => $number1, 'number2' => $number2);
}

function verifySolution($data) {
    try {
        $number1 = $data['number1'];
        $number2 = $data['number2'];
        $correctProduct = $number1 * $number2;
        $correctSum = $number1 + $number2;
        return $data['product'] == $correctProduct && $data['sum'] == $correctSum;
    } catch (Exception $e) {
        return false;
    }
}
?>
