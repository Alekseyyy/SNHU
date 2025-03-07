import sys

if len(sys.argv) != 2:
    print("usage: ini6.py <dataset>")
    sys.exit(-1)

tally_board = {}
with open (sys.argv[1], "r") as dataset:
    words = dataset.read().split("\n")[0].split(" ")
    for word in words:
        if word not in tally_board:
            tally_board[word] = 0
        tally_board[word] += 1
    for k in tally_board:
        print(k, tally_board[k])

