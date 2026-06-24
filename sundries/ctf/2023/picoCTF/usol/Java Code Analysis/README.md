# Java Code Analysis!?!

Author: Nandan Desai
Location: https://play.picoctf.org/events/72/challenges/challenge/355
Tags: Web Exploitation

## Problem

> __Due to Instance Launching maintenance, you may access the challenge download file to work offline:__ Source code can be downloaded [here](https://artifacts.picoctf.net/c/483/bookshelf-pico.zip). BookShelf Pico, my premium online book-reading service. I believe that my website is super secure. I challenge you to prove me wrong by reading the 'Flag' book! Additional details will be available after launching your challenge instance.

This challenge has a zip archive download called ``bookshelf-pico.zip`` ([download it here](./bootshelf-pico.zip)), and four hints:

1. Maybe try to find the JWT Signing Key ("secret key") in the source code? Maybe it's hardcoded somewhere? Or maybe try to crack it?
2. The 'role' and 'userId' fields in the JWT can be of interest to you!
3. The 'controllers', 'services' and 'security' java packages in the given source code might need your attention. We've provided a README.md file that contains some documentation.
4. Upgrade your 'role' with the new (cracked) JWT. And re-login for the new role to get reflected in browser's localStorage.

## Solution

I started by downloading the zip archive and extracting it:

```
dna@deniers:~/Java Code Analysis$ unzip bookshelf-pico.zip
Archive:  bookshelf-pico.zip
   creating: gradle/
   creating: gradle/wrapper/
  inflating: gradle/wrapper/gradle-wrapper.jar  
  inflating: gradle/wrapper/gradle-wrapper.properties  
   creating: src/
   creating: src/main/
   creating: src/main/java/
   creating: src/main/java/io/
   creating: src/main/java/io/github/
   creating: src/main/java/io/github/nandandesai/
   creating: src/main/java/io/github/nandandesai/pico/
  inflating: src/main/java/io/github/nandandesai/pico/BookShelfBaseServerApplication.java  
   creating: src/main/java/io/github/nandandesai/pico/configs/
  inflating: src/main/java/io/github/nandandesai/pico/configs/BookShelfConfig.java  
  inflating: src/main/java/io/github/nandandesai/pico/configs/UserDataPaths.java  

[... snip ...]

dna@deniers:~/Java Code Analysis$ 
```

The contents of the ``.zip`` archive can show itself to be useful if I need to reference the source code. I launched the instance (Figure 1) and a website with the following credentials are here:

```
Here are the credentials to get you started:

    Username: "user"
    Password: "user"

Source code can be downloaded here. Website can be accessed here!.
```

I visited the website and entered in the username ``user`` and the password ``user`` to get into the website (Figures 2, 3). The web application has redirected to a catalogue of books (Figure 4) with one of them entitled "flag." The challenge asked me to try to read the book, so I clicked on the "flag" image and the web application told me that I did not have permissions to read it (Figure 5). 

To test how much access to books that I have, I tried to access the other book titles; I tried to read the "Little Brother" book, which I appear to have permission to read it (Figure 6) --- and from the web application's description, I may read it after picoCTF 2023 is over ;-) I also tried to read "The Future of the Internet" and, like with the "Flag" book, I cannot read it (Figure 7). Like with Little Brother, I might read this book later ;-)

From the first hint, I decided to research "JWT Signing Key" and came up with some articles [1][2][3][4].

## References

1. https://auth0.com/docs/get-started/tenant-settings/signing-keys
2. https://auth0.com/docs/secure/tokens/json-web-tokens/json-web-key-sets
3. https://jwt.io/introduction
4. https://dev.to/kimmaida/signing-and-validating-json-web-tokens-jwt-for-everyone-25fb
