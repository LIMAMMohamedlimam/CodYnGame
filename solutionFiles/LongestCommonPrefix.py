def longestCommonPrefix(strs):
    if not strs:
        return ""

    prefix = strs[0]

    for i in range(1, len(strs)):
        while strs[i].startswith(prefix) == False:
            prefix = prefix[:-1]
            if len(prefix) == 0:
                return ""

    return prefix