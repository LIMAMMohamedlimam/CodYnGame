function mergeTwoSortedLists(list1, list2) {
    let mergedList = [];
    let i = 0, j = 0;

    // Traverse both lists and append the smaller element to the merged list
    while (i < list1.length && j < list2.length) {
        if (list1[i] <= list2[j]) {
            mergedList.push(list1[i]);
            i++;
        } else {
            mergedList.push(list2[j]);
            j++;
        }
    }

    // Append remaining elements, if any
    while (i < list1.length) {
        mergedList.push(list1[i]);
        i++;
    }

    while (j < list2.length) {
        mergedList.push(list2[j]);
        j++;
    }

    return mergedList;
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
