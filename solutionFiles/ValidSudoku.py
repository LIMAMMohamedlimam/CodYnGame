

def is_valid_sudoku(board):
    # Vérification des lignes et des colonnes
    for i in range(9):
        row_set = set()
        col_set = set()
        for j in range(9):
            # Vérification des lignes
            if board[i][j] != '.':
                if board[i][j] in row_set:
                    return False
                row_set.add(board[i][j])
            # Vérification des colonnes
            if board[j][i] != '.':
                if board[j][i] in col_set:
                    return False
                col_set.add(board[j][i])

    # Vérification des sous-grilles 3x3
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            square_set = set()
            for k in range(3):
                for l in range(3):
                    if board[i + k][j + l] != '.':
                        if board[i + k][j + l] in square_set:
                            return False
                        square_set.add(board[i + k][j + l])

    return True

def main():
    # Entrée de l'utilisateur : une grille Sudoku sous forme de liste de listes
    sudoku_board = []
    print("Entrez la grille Sudoku, ligne par ligne, en utilisant '.' pour les cases vides :")
    for _ in range(9):
        row = input().strip().split()
        sudoku_board.append(row)

    # Appel de la fonction pour vérifier si la grille Sudoku est valide
    if is_valid_sudoku(sudoku_board):
        print("La grille Sudoku est valide.")
    else:
        print("La grille Sudoku n'est pas valide.")

if __name__ == "__main__":
    main()
