
import sys

if len(sys.argv) != 2:
    print("usage: ini2.py <dataset>")
    sys.exit(-1)
    
with open(sys.argv[1], "r") as dataset:
    for line in dataset.readlines():
        try:
            inputs = line.split(" ")
            x = int(inputs[0])
            y = int(inputs[1])
            print(x**2 + y**2)
        except:
            pass

