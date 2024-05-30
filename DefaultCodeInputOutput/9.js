function mergeTwoSortedLists(list1, list2) {
  //Write your code here
}

function main() {
  // Assuming the input is passed as the first command line argument
  const inputJson = process.argv[2];

  // Parse the JSON input
  const data = JSON.parse(inputJson);
  const list1 = data.list1 || [];
  const list2 = data.list2 || [];

  // Merge the two sorted lists
  const mergedList = mergeTwoSortedLists(list1, list2);

  // Prepare the result in the desired format
  const result = { result: mergedList };

  // Print the result as a JSON string
  console.log(JSON.stringify(result));
}

main();
