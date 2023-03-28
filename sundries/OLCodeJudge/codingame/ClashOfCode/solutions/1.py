import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

X, Y = 0, 0

n = int(input())
for step in input().split():
    if step == "L":
        X = X - 1
    elif step == "R":
        X = X + 1
    elif step == "F":
        Y = Y + 1
    elif step == "B":
        Y = Y - 1

print(int(math.sqrt(X**2 + Y**2)))

# Write an answer using print
# To debug: print("Debug messages...", file=sys.stderr, flush=True)
