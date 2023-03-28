
# sources:
# 1. https://www.geeksforgeeks.org/python-convert-string-to-bytes/
# 2. https://docs.python.org/3/library/base64.html

import base64
import binascii

with open("enc_flag", "rb") as binput:
    enc_input = binput.read()
    
    i, done = 1, False
    while not done:
        enc_input = base64.b64decode(enc_input)
        print("Iterations:", i)
        if "picoCTF".encode("utf-8") in enc_input:
            print("Flag:", enc_input)
            done = True
        i += 1
