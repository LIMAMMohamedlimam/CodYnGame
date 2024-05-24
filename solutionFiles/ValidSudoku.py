def isValidSudoku(board):
    # Fonction pour vérifier si le tableau de Sudoku est valide
    # Le tableau est valide si toutes les lignes, colonnes et sous-grilles 3x3
    # ne contiennent pas de doublons de chiffres de 1 à 9

    # Vérifie les lignes
    for i in range(9):
        row = board[i]
        if not isValidRow(row):
            return False
        
        # Vérifie les colonnes
        col = [board[j][i] for j in range(9)]
        if not isValidRow(col):
            return False
    
    # Vérifie les sous-grilles 3x3
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            subgrid = [board[x][y] for x in range(i, i+3) for y in range(j, j+3)]
            if not isValidRow(subgrid):
                return False
    
    return True

def isValidRow(row):
    # Fonction pour vérifier si une ligne contient des chiffres de 1 à 9 sans doublons
    seen = set()
    for num in row:
        # Ignore les cases vides
        if num == '.':
            continue
        if num in seen:
            # Si un chiffre est déjà présent dans la ligne, le tableau n'est pas valide
            return False
        seen.add(num)
    # Si tous les chiffres sont uniques, la ligne est valide
    return True

