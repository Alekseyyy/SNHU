
import sys

if len(sys.argv) != 2:
    print("usage: ini4.py <dataset>")
    sys.exit(-1)
    
with open(sys.argv[1], "r") as dataset:
    read_dataset = dataset.read().split(" ")
    a = int(read_dataset[0])
    b = int(read_dataset[1])
    summa = 0
    for k in range(a, b + 1):
        if k % 2 != 0:
            summa += k
    print (summa)

