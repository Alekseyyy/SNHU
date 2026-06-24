
import sys

fib_sequence = [1, 1]

if len(sys.argv) != 2:
    print("usage: fibo.py <dataset>")
    sys.exit(-1)
    
with open(sys.argv[1], "r") as dataset:
    n = int(dataset.read())
    while len(fib_sequence) < n:
        a = fib_sequence[len(fib_sequence) - 1]
        b = fib_sequence[len(fib_sequence) - 2]
        fib_sequence.append(a + b)

    print(fib_sequence[len(fib_sequence) - 1])

