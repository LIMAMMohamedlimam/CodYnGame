const fs = require('fs');

function twoSum(nums, target) {
    const numDict = {};

    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];
        const complement = target - num;
        if (complement in numDict) {
            return JSON.stringify([numDict[complement], i]);
        }
        numDict[num] = i;
    }

    return JSON.stringify([]);  // In case no solution is found (though the problem guarantees a solution)
}

if (process.argv.length !== 3) {
    console.log("Usage: node script.js '{\"nums\": [...], \"target\": ...}'");
    process.exit(1);
}

const inputJson = process.argv[2];
try {
    const inputData = JSON.parse(inputJson);
    const nums = inputData.nums;
    const target = inputData.target;
    console.log(twoSum(nums, target));
} catch (e) {
    console.log("Invalid input format. Please provide a JSON string with 'nums' and 'target'.");
}
