# repetitions

* Author: Theoneste Byagutangaza
* Location: https://play.picoctf.org/practice/challenge/371
* Tags: General Skills, base64

## Problem 

> Can you make sense of this file? Download the file here.

This problem came with a file ([enc_flag](./enc_flag])) and a hint that stated "Multiple decoding is always good."

## Solution

Based on the information given to me, I assumed that this was a __base64__ encoding scheme. From the name "repetitions" and the tag of "base64," I figured that this is an iterative base64 encoding.

I devised a couple of techniques for decoding. The first included piping the file's contents through Linux's ``base64`` command multiple times:

```bash
dna@deniers:~/repetitions$ cat enc_flag | base64 --decode | base64 --decode | base64 --decode | base64 --decode | base64 --decode | base64 --decode
picoCTF{base64_n3st3d_dic0d!n8_d0wnl04d3d_69f084d6}
dna@deniers:~/Documents/Blogging/Medium/picoCTF/2023/repetitions$ 
```

The second solution is with the following Python script:

```python
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
```

## References

1. [https://linuxhint.com/bash_base64_encode_decode/](https://linuxhint.com/bash_base64_encode_decode/)
