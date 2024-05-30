function lengthOfLongestSubstring(s) {
  //Write your code here
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
