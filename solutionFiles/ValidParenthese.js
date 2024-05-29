const process = require('process');

function isValidParentheses(s) {
    const stack = [];
    const mapping = { ')': '(', '}': '{', ']': '[' };

    for (let char of s) {
        if (Object.values(mapping).includes(char)) {
            stack.push(char);
        } else if (Object.keys(mapping).includes(char)) {
            if (stack.length && stack[stack.length - 1] === mapping[char]) {
                stack.pop();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    return stack.length === 0;
}

function main() {
    // Read the JSON string from program argument
    const inputJson = process.argv[2];
    const inputData = JSON.parse(inputJson);

    const s = inputData.s;
    const result = isValidParentheses(s);

    // Output the result as JSON string
    const outputJson = JSON.stringify({ result: result });
    console.log(outputJson);
}

if (require.main === module) {
    main();
}
