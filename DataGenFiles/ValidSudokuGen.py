import sys
import json
import random

def generate_board():
    board = [['.' for _ in range(9)] for _ in range(9)]
    for _ in range(random.randint(15, 30)):
        row = random.randint(0, 8)
        col = random.randint(0, 8)
        num = str(random.randint(1, 9))
        board[row][col] = num
    return board

def is_valid_sudoku(board):
    def is_valid_unit(unit):
        unit = [i for i in unit if i != '.']
        return len(unit) == len(set(unit))

    def is_valid_row(board):
        for row in board:
            if not is_valid_unit(row):
                return False
        return True

    def is_valid_col(board):
        for col in zip(*board):
            if not is_valid_unit(col):
                return False
        return True

    def is_valid_square(board):
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                square = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                if not is_valid_unit(square):
                    return False
        return True

    return is_valid_row(board) and is_valid_col(board) and is_valid_square(board)

def verifysolution(jsondata, resultdata):
    try:
        with open(jsondata, 'r') as f:
            data = json.load(f)
        with open(resultdata, 'r') as f:
            result = json.load(f)

        board = data['board']
        expected_validity = result['is_valid']

        return is_valid_sudoku(board) == expected_validity
    except Exception as e:
        return False

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Error: No operation specified.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
    elif sys.argv[1] == "gen":
        board = generate_board()
        data = {"board": board}
        print(json.dumps(data))
    elif sys.argv[1] == "verify" and len(sys.argv) == 4:
        jsondata = sys.argv[2]
        resultdata = sys.argv[3]
        if verifysolution(jsondata, resultdata):
            print("Solution is correct.")
        else:
            print("Solution is incorrect.")
    else:
        print("Error: Incorrect arguments or number of arguments.")
        print("Usage: python script.py gen OR python script.py verify <jsondata> <resultdata>")
