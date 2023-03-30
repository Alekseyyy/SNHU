# rotation

* Author: Loic Shema
* Location: https://play.picoctf.org/events/72/challenges/challenge/373
* Tags: Cryptography

## Problem

> You will find the flag after decrypting this file Download the encrypted flag [here](https://artifacts.picoctf.net/c/386/encrypted.txt).

This challenge came with a hint stating that "[s]ometimes rotation is right" and a file called ``encrypted.txt`` ([download it here](./encrypted.txt)).

## Solution

I downloaded the encrypted flag and proceeded to brute force it. I used an app [1] that attacks simple rotation ciphers with the aforementioned brute force method, and it worked out the flag to be ``picoCTF{r0tat1on_d3crypt3d_4c71f5b0}``.

__TODO:__ Write a script to hack the cryptogram.

## References

1. https://www.dcode.fr/caesar-cipher

