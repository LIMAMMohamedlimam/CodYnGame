const process = require('process');

function maxArea(height) {
    //Write your code here
}

if (process.argv.length !== 3) {
    console.error("Usage: node script.js '<json_string>'");
    process.exit(1);
}

try {
    const inputJson = process.argv[2];
    const data = JSON.parse(inputJson);
    const height = data.height;

    if (!Array.isArray(height)) {
        throw new Error("Invalid height data");
    }

    const result = maxArea(height);
    const outputJson = JSON.stringify({ result: result });

    console.log(outputJson);
} catch (error) {
    console.error("Invalid JSON input");
    process.exit(1);
}
