def two_sum(nums, target):
    num_to_index = {}  # Dictionnaire pour stocker les numéros et leurs indices

    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_to_index:
            return [num_to_index[complement], i]
        num_to_index[num] = i

    return None  # Si aucune paire n'est trouvée

# Exemple d'utilisation
nums = [2, 7, 11, 15]
target = 9
print(two_sum(nums, target))  # Devrait renvoyer [0, 1] car nums[0] + nums[1] = 2 + 7 = 9
