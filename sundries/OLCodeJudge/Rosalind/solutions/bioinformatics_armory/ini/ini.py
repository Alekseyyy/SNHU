
import sys

if len(sys.argv) != 2:
    print("usage: dna.py <dataset>")
    sys.exit(-1)
    
with open(sys.argv[1], "r") as dataset:
    dna_sequence = dataset.read().upper()
    
    tally_board = {
        "A":0,
        "C":0,
        "G":0,
        "T":0
    }
    
    for character in dna_sequence:
        if character == "A":
            tally_board["A"] += 1
        elif character == "C":
            tally_board["C"] += 1
        elif character == "G":
            tally_board["G"] += 1
        elif character == "T":
            tally_board["T"] += 1
        else:
            pass
            
    print(
        tally_board["A"], tally_board["C"], tally_board["G"], tally_board["T"]
    )

