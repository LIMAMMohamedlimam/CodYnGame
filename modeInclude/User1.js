function reverseInteger(x) {
    // Check for the sign of the number
    const sign = x < 0 ? -1 : 1;
    x *= sign;

    // Reverse the digits of the number
    let reversedX = parseInt(x.toString().split('').reverse().join(''), 10);

    // Restore the sign
    reversedX *= sign;

    // Check if the reversed integer is within the 32-bit signed integer range
    if (reversedX < -(2**31) || reversedX > (2**31 - 1)) {
        return 0;
    }

    return reversedX;
}

function main() {
    // Read the input JSON string from the command line arguments
    const inputJson = process.argv[2];

    // Parse the JSON string to get the integer
    const inputData = JSON.parse(inputJson);
    const x = inputData.x;

    // Get the reversed integer
    const result = reverseInteger(x);

    // Prepare the output as a JSON string
    const outputJson = JSON.stringify({result: result});

    // Print the output JSON string
    console.log(outputJson);
}

if (require.main === module) {
    main();
}
