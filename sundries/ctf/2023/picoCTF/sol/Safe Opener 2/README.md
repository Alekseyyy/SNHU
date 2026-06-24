# Safe Opener 2

* Author: Mubarak Mikail
* Location: https://play.picoctf.org/practice/challenge/375

## Problem 

> What can you do with this file? I forgot the key to my safe but this file is supposed to help me with retrieving the lost key. Can you help me unlock my safe?

This challenge came with a file called ``SafeOpener.class`` ([download it here](./SafeOpener.class))

## Solution

This looked like it was a Java class file, so I proceeded to decompile it with [Java Decompiler]() (see Figure 1, Figure 2). I quickly worked out that the flag was in a ``boolean`` function called ``openSafe(String password)``

```java
  public static boolean openSafe(String password) {
    String encodedkey = "picoCTF{SAf3_0p3n3rr_y0u_solv3d_it_6d84122a}";
    if (password.equals(encodedkey)) {
      System.out.println("Sesame open");
      return true;
    } 
    System.out.println("Password is incorrect\n");
    return false;
  }
```
