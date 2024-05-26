import random
import json

def generate_board():
    board = [['.' for _ in range(9)] for _ in range(9)]
    for _ in range(random.randint(15, 30)):
        row = random.randint(0, 8)
        col = random.randint(0, 8)
        num = str(random.randint(1, 9))
        board[row][col] = num
    return board

board = generate_board()

data = {"board": board}
print(data)
with open("valid_sudoku_input.json", "w") as json_file:
    json.dump(data, json_file)
