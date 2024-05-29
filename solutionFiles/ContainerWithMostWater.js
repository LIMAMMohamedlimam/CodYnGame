const process = require('process');

function maxArea(height) {
    let left = 0;
    let right = height.length - 1;
    let maxArea = 0;

    while (left < right) {
        let width = right - left;
        let h = Math.min(height[left], height[right]);
        let currentArea = width * h;
        maxArea = Math.max(maxArea, currentArea);

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxArea;
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
