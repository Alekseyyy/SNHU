
alphabet_pos2let = {
    1:"a", 2:"b", 3:"c", 4:"d", 5:"e", 6:"f", 7:"g", 8:"h", 9:"i", 10:"j", 11:"k", 12:"l",
    13:"m", 14:"n", 15:"o", 16:"p", 17:"q", 18:"r", 19:"s", 20:"t", 21:"u", 22:"v", 23:"w",
    24:"x", 25:"y", 26:"z"
}

alphabet_let2pos = {
    "a":1, "b":2, "c":3, "d":4, "e":5, "f":6, "g":7, "h":8, "i":9, "j":10, "k":11, "l":12,
    "m":13, "n":14, "o":15, "p":16, "q":17, "r":18, "s":19, "t":20, "u":21, "v":22, "w":23,
    "x":24, "y":25, "z":26
}

cryptogram = "krxlXGU{zgyzhs_xizxp_92533667}"
cryptogram = list(cryptogram.lower())

decoded_string = ""
for n, k in enumerate(cryptogram):
    if not k.isalnum():
        decoded_string += k
    else:
        if not k.isnumeric():
            if n % 2 != 0:
                current_letter_pos = alphabet_let2pos[k]
                decoded_string += alphabet_pos2let[(current_letter_pos + 9) % 26]
            else:
                current_letter_pos = alphabet_let2pos[k]
                decoded_string += alphabet_pos2let[(current_letter_pos - 5) % 26]
        else:
            decoded_string += k
        
print("Decoded string:", decoded_string)
