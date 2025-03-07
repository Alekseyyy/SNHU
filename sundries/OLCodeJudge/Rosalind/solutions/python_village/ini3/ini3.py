
import sys

if len(sys.argv) != 2:
    print("usage: ini3.py <dataset>")
    sys.exit(-1)
    
with open(sys.argv[1], "r") as dataset:
    inputs = dataset.read().split("\n")
    target_string = inputs[0]
    substring_parameters = inputs[1].split(" ")
    
    a_i = int(substring_parameters[0])
    a_f = int(substring_parameters[1])
    b_i = int(substring_parameters[2])
    b_f = int(substring_parameters[3])
    
    print (target_string[a_i:a_f + 1], target_string[b_i:b_f + 1])

