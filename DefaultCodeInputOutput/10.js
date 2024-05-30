const longestCommonPrefix = (strs) => {
  //Write your code here;
};

const main = () => {
  if (process.argv.length < 3) {
      console.error(JSON.stringify({ error: "No input provided" }));
      process.exit(1);
  }

  const inputStr = process.argv[2];
  let strs;
  try {
      const data = JSON.parse(inputStr);
      if (!data || typeof data !== 'object' || !Array.isArray(data.strs)) {
          throw new Error();
      }
      strs = data.strs;
      if (!strs.every(s => typeof s === 'string')) {
          throw new Error();
      }
  } catch (e) {
      console.error(JSON.stringify({ error: "Invalid input" }));
      process.exit(1);
  }

  const result = longestCommonPrefix(strs);
  console.log(JSON.stringify({ longest_common_prefix: result }));
};

main();
