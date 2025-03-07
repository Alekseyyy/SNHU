import sys

if len(sys.argv) != 2:
    print("usage: ini5.py <dataset>")
    sys.exit(-1)

with open (sys.argv[1], "r") as dataset:
    for n, k in enumerate(dataset.read().split("\n")):
        if (n + 1) % 2 == 0:
            print (k)

