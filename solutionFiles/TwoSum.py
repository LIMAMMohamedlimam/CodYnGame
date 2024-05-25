import json

def TwoSum(nums, target):
    num_to_index = {}  # Dictionnaire pour stocker les numéros et leurs indices

    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_to_index:
            return [num_to_index[complement], i]
        num_to_index[num] = i

    return None  # Si aucune paire n'est trouvée

def main(generatedData):
    # Utiliser les données pour exécuter la fonction TwoSum
    nums = generatedData["nums"]
    target = generatedData["target"]
    result = TwoSum(nums, target)
    print(generatedData)
    print(result)

if __name__ == "__main__":
    # Si le script est exécuté en tant que programme principal
    with open("twosum_input.json") as json_file:
        generatedData = json.load(json_file)
    main(generatedData)
