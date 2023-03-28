# HideToSee

Author: Sunday Jacob Nwanyim
Location: https://play.picoctf.org/events/72/challenges/challenge/351
Tags: Cryptography

## Problem 

> How about some hide and seek heh? Look at this image [here](https://artifacts.picoctf.net/c/235/atbash.jpg).

The challenge came with a single hint that states "[d]ownload the image and try to extract it." It also came with a file called ``atbash.jpg`` ([download it here](./atbash.jpg)).

## Solution

I downloaded the image and tried to extract it with ``binwalk``:

```
dna@deniers:~/HideToSee$ binwalk -e atbash.jpg

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             JPEG image data, JFIF standard 1.01

dna@deniers:~/HideToSee$ ls -l
total 56
-rw-rw-r-- 1 dna dna 51499 Mar 19 09:48 atbash.jpg
-rw-rw-r-- 1 dna dna   377 Mar 19 09:49 notes.md
dna@deniers:~/HideToSee$ 
```

... to no avail. I then proceeded to use ``exiftool`` to attempt to get some basic information about the image:

```
dna@deniers:~/HideToSee$ exiftool atbash.jpg
ExifTool Version Number         : 11.88
File Name                       : atbash.jpg
Directory                       : .
File Size                       : 50 kB
File Modification Date/Time     : 2023:03:19 09:48:31-04:00
File Access Date/Time           : 2023:03:19 09:49:45-04:00
File Inode Change Date/Time     : 2023:03:19 09:48:35-04:00
File Permissions                : rw-rw-r--
File Type                       : JPEG
File Type Extension             : jpg
MIME Type                       : image/jpeg
JFIF Version                    : 1.01
Resolution Unit                 : None
X Resolution                    : 1
Y Resolution                    : 1
Image Width                     : 465
Image Height                    : 455
Encoding Process                : Baseline DCT, Huffman coding
Bits Per Sample                 : 8
Color Components                : 3
Y Cb Cr Sub Sampling            : YCbCr4:2:0 (2 2)
Image Size                      : 465x455
Megapixels                      : 0.212
dna@deniers:~/HideToSee$ 
```

I then tried to use ``stegseek`` to get the flag:

```
dna@deniers:~/HideToSee$ stegseek atbash.jpg ~/Documents/rockyou.txt
StegSeek 0.6 - https://github.com/RickdeJager/StegSeek

[i] Found passphrase: ""
[i] Original filename: "encrypted.txt".
[i] Extracting to "atbash.jpg.out".
the file "atbash.jpg.out" does already exist. overwrite ? (y/n) 
y
dna@deniers:~/HideToSee$ 
```

Which resulted in the following output:

```
dna@deniers:~/HideToSee$ cat atbash.jpg.out
krxlXGU{zgyzhs_xizxp_92533667}
dna@deniers:~/HideToSee$ 
```

I figured this could be a ROT13 cipher, so I attempted to decode it with a ROT13 (with "13" being any other number of rotations) cracker [2][3]. It turned out that this flag could not be cracked with the ROT(N) decrypter.

This is "a piece of cake" at this point. I know that the flag must contain ``picoCTF{``, so I know what ciphertext letters map-out to what plaintext letters:

|__ciphertext__|__plaintext__|
|-|-|
|k|p|
|r|i|
|x|c|
|l|o|
|X|C|
|G|T|
|U|F|

I then mapped the plaintext letters to their respective ciphertext letters:

* ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
* ??????T?????????????F??C??????????i?p???o????????c??

From this, I worked out the following flag:

```
C: krxlXGU{zgyzhs_xizxp_92533667}
P: picoCTF{??????_cr?ck_????????}
```

I believe to have worked out the pattern: the cryptogram is case __insensitive__, and adds goes up 5 characters, then subtracts 9 the next string and repeats the process for the entire string for alphanumeric characters. 

So, I manually cracked the cryptogram like so:

```
     C: krxlXGU{zgyzhs_xizxp_92533667}
So far: picoCTF{??????_cr?ck_????????}
   ---> picoCTF{??????_crack_92533667} (it just made sense :p)
   ---> picoCTF{a??a??_crack_92533667} (knowing that z = a)
   ---> picoCTF{at?a??_crack_92533667} (knowing that T = t = G = g)
   ---> picoCTF{attack_crack_92533667} (it just made sense lol)
```

This solution is incorrect.

I decided to try to work on a simpler model to derive a solution, and quickly recalled a toy model for solving polyalphabetic ciphers from an episode of CyberChase [4] complete with a small toolkit for constructing a toy cryptanalysis "decoder ring" to crack this kind of cryptogram. 

## References

1. https://fareedfauzi.gitbook.io/ctf-checklist-for-beginner/cryptography
2. https://rot13.com/
3. https://www.cachesleuth.com/rot.html
4. Season 7 Episode 5. 
4. http://r53-vip-soup.pbskids.org/cyberchase/fathers_day/download/Cyb_Coder_Decoder.pdf
