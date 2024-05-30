const longestCommonPrefix = (strs) => {
    if (!strs.length) return "";

    let prefix = strs[0];
    for (let i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) !== 0) {
            prefix = prefix.slice(0, -1);
            if (!prefix) return "";
        }
    }
    return prefix;
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
