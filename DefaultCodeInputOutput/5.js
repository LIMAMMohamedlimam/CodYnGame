const process = require('process');

        function isPalindrome(x) {
        //Write your code here
        }

        function main() {
        if (process.argv.length !== 3) {
        console.log(JSON.stringify({ error: "Invalid input" }));
        return;
        }

        try {
        const inputJson = process.argv[2];
        const data = JSON.parse(inputJson);
        const x = data.x;

        if (typeof x !== 'number') {
        console.log(JSON.stringify({ error: "Value is not an integer" }));
        return;
        }

        const result = isPalindrome(x);
        console.log(JSON.stringify({ result: result }));
        } catch (error) {
        console.log(JSON.stringify({ error: "Invalid JSON or missing key 'x'" }));
        }
        }

        main();
