def longest_common_prefix(strs):
    if not strs:
        return ""


    strs.sort()
    shortest = strs[0]
    longest = strs[-1]

    
    for i in range(len(shortest)):
        if shortest[i] != longest[i]:
            return shortest[:i]

    return shortest

def main(generatedData):
    strs = generatedData["strs"]
    result = longest_common_prefix(strs)
    print(result)

if __name__ == "__main__":
    main()
