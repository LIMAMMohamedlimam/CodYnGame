const process = require('process');

function romanToInt(s) {
    //Write your code here
}

function main() {
    if (process.argv.length !== 3) {
        console.log("Usage: node script.js '<json_string>'");
        return;
    }

    const inputJson = process.argv[2];
    try {
        const data = JSON.parse(inputJson);
        const romanNumeral = data.roman;
        if (!romanNumeral) {
            console.log(JSON.stringify({ error: "No roman numeral found" }));
            return;
        }

        const integerValue = romanToInt(romanNumeral);
        const result = JSON.stringify({ result: integerValue });
        console.log(result);
    } catch (e) {
        console.log(JSON.stringify({ error: "Invalid JSON input" }));
    }
}

main();
