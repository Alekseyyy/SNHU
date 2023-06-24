# Reverse

* Author: Mubarak Mikail
* Location: https://play.picoctf.org/practice/challenge/372
* Reverse Engineering

## Problem 

Description:

> Try reversing this file? Can ya? I forgot the password to this file. Please find it for me?

This problem came with a file called ``ret`` ([download it here](./ret)).

## Solution 

I presumed ``ret`` to be an executable binary. I decided to decompile it with Ghidra (see Figure 1, Figure 2). I decompiled the ``main`` function and found the flag in the source code:

```c++

[... snip ...]

  local_20 = 0x6c75663535656363;
  local_18 = 0x656533656530375f;
  printf("Enter the password to unlock this file: ");
  __isoc99_scanf(&DAT_00102031,local_68);
  printf("You entered: %s\n",local_68);
  iVar1 = strcmp(local_68,(char *)&local_38);
  if (iVar1 == 0) {
    puts("Password correct, please see flag: picoCTF{3lf_r3v3r5ing_succe55ful_70ee3eeb}");
    puts((char *)&local_38);
  }
  else {
    puts("Access denied");
  }
  if (local_10 != *(long *)(in_FS_OFFSET + 0x28)) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();

[... snip ...]

```
