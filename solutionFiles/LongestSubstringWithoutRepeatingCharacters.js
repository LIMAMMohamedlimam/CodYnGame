function lengthOfLongestSubstring(s) {
    let charSet = new Set();
    let left = 0;
    let maxLength = 0;

    for (let right = 0; right < s.length; right++) {
        while (charSet.has(s[right])) {
            charSet.delete(s[left]);
            left++;
        }
        charSet.add(s[right]);
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

function main() {
    if (process.argv.length !== 3) {
        console.log("Please provide a single JSON string argument.");
        return;
    }

    let inputJson = process.argv[2];
    let inputData;
    try {
        inputData = JSON.parse(inputJson);
    } catch (e) {
        console.log("Invalid JSON input.");
        return;
    }

    let s = inputData.s || "";
    let result = lengthOfLongestSubstring(s);
    let output = { result: result };
    console.log(JSON.stringify(output));
}

main();
