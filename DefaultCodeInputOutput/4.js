function reverseInteger(x) {
  //Write your code here
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
