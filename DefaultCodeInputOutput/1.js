    const fs = require('fs');

    function twoSum(nums, target) {
    //write here your code
  
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
    