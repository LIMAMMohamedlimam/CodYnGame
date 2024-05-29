const process = require('process');

function romanToInt(s) {
    const romanToValue = {
        'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000
    };
    let total = 0;
    let prevValue = 0;

    for (let i = s.length - 1; i >= 0; i--) {
        const value = romanToValue[s[i]];
        if (value < prevValue) {
            total -= value;
        } else {
            total += value;
        }
        prevValue = value;
    }

    return total;
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
